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
    
    
    
def trajectory(velocity_field, long_0, lat_0):
    



f = open("data.txt", "r")

for line in f:
    data = ast.literal_eval(line)['grid']



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




































