# -*- coding: utf-8 -*-
"""
Created on Sat Apr 13 11:30:34 2019

@author: Ariadne Thompson
"""

import numpy as np
import matplotlib.pyplot as plt
import ast
#import requests

LAT_UPPER_LIMIT = 60
LAT_LOWER_LIMIT = 50
LONG_UPPER_LIMIT = -12
LONG_LOWER_LIMIT = -19

#response = requests.get(
#  'https://api.stormglass.io/area',
#  params={
#      'box': 'LAT_UPPER_LIMIT,LONG_UPPER_LIMIT:LAT_LOWER_LIMIT,LONG_LOWER_LIMIT',
#      'params': 'currentDirection,currentSpeed'
#  },
#  headers={
#    'Authorization': '06454c78-5ded-11e9-9518-0242ac130004-06454d72-5ded-11e9-9518-0242ac130004'
#  }
#)
#
#json_data = response.json()['grid']



def radial_to_euclidean(theta, r):
    # Radial data is relative to North; should be relative to x axis (latitude)
    theta = (theta + 90) % 360
    theta *= - np.pi / 180
    return r * np.cos(theta), r * np.sin(theta)



def plot_vector_field(velocity_field):
    lat_grid = np.arange(LAT_LOWER_LIMIT, LAT_UPPER_LIMIT+1)
    long_grid = np.arange(LONG_LOWER_LIMIT, LONG_UPPER_LIMIT+1)
    
    fig, ax = plt.subplots()
    ax.quiver(long_grid, lat_grid, velocity_field["long_vel"][:,:,0], velocity_field["lat_vel"][:,:,0], scale=2.5)
    ax.set_xlabel("Longitude")
    ax.set_ylabel("Latitude")
    
    plt.show()
    
    
    
def trajectory(velocity_field, long_dropped, lat_dropped, time_steps):
    output = open("trajectory.txt", "w")
    
    # Convert velocity field from m/s to degrees/hour. 
    mean_lat = 55 * np.pi / 180
    
    # 1 degree latitude ~ 111111 m
    # 1 degree longitude ~ 111111 * cos(latitude) m
    velocity_field["lat_vel"] /= 11111
    velocity_field["long_vel"] /= 11111 * np.cos(mean_lat)
    
    # 3600 s = 1 hr
    velocity_field["lat_vel"] *= 3600
    velocity_field["long_vel"] *= 3600
    
    long, lat = long_dropped, lat_dropped
    
    output.write(", ".join((str(long), str(lat), "0")))
    
    for t in range(time_steps):
        long_vel = velocity_field["long_vel"][int(round(long) - LONG_LOWER_LIMIT), int(round(lat) - LAT_LOWER_LIMIT), 0]
        lat_vel = velocity_field["lat_vel"][int(round(long) - LONG_LOWER_LIMIT), int(round(lat) - LAT_LOWER_LIMIT), 0]
        
        long += long_vel
        lat += lat_vel
        
        output.write("\n")
        output.write(", ".join((str(long), str(lat), str(t))))
    
    output.close()



f = open("data.txt", "r")

for line in f:
    data = ast.literal_eval(line)['grid']

f.close()

# Longitudinal and latitudinal components of velocity. 
current = np.dtype([("long_vel", np.float64), ("lat_vel", np.float64)])


lat_grid_size = LAT_UPPER_LIMIT - LAT_LOWER_LIMIT + 1
long_grid_size = LONG_UPPER_LIMIT - LONG_LOWER_LIMIT + 1
time_grid_size = 8

velocity_field = np.empty(shape=(lat_grid_size, long_grid_size, time_grid_size), dtype=current)

i = 0

for long in data.keys():
    j = 0
    
    for lat in data[long].keys():
        for k in range(8):
            velocity_field[i][j][k]["lat_vel"], velocity_field[i][j][k]["long_vel"] = radial_to_euclidean(data[long][lat][k]["currentDirection"], data[long][lat][k]["currentSpeed"])
        j += 1
    i += 1



plot_vector_field(velocity_field)

#trajectory(velocity_field, -17, 52, 72)






































