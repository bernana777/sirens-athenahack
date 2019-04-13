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



f = open("data.txt", "r")

for line in f:
    data = ast.literal_eval(line)['grid']



currents = np.dtype([("direction", np.float64), ("speed", np.float64), ("long", np.float64), ("lat", np.float64), ("time", np.float64)])


































