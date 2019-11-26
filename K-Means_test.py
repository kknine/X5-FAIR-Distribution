import pandas as pd
import numpy as np
import random as rd
import matplotlib.pyplot as plt

data = pd.read_csv('clustering.csv')

X = data[["Data_1","Data_3","Data_2"]]

K=7


Centroids = (X.sample(n=K))

diff = 1
j=0

while(diff!=0):
    XD=X
    i=1
    for index1,row_c in Centroids.iterrows():
        ED=[]
        for index2,row_d in XD.iterrows():
            d1=(row_c["Data_3"]-row_d["Data_3"])**2
            d2=(row_c["Data_1"]-row_d["Data_1"])**2
            d3=(row_c["Data_2"]-row_d["Data_2"])**2
            d=np.sqrt(d1+d2+d3)
            ED.append(d)
        X[i]=ED
        i=i+1

    C=[]
    for index,row in X.iterrows():
        min_dist=row[1]
        pos=1
        for i in range(K):
            if row[i+1] < min_dist:
                min_dist = row[i+1]
                pos=i+1
        C.append(pos)
    X["Cluster"]=C
    Centroids_new = X.groupby(["Cluster"]).mean()[["Data_1","Data_3","Data_2"]]
    if j == 0:
        diff=1
        j=j+1
    else:
        diff = (Centroids_new['Data_1'] - Centroids['Data_1']).sum() + (Centroids_new['Data_3'] - Centroids['Data_3']).sum() + (Centroids_new['Data_2'] - Centroids['Data_2']).sum()
        print(diff.sum())
    Centroids = X.groupby(["Cluster"]).mean()[["Data_1","Data_3","Data_2"]]



color=['blue','orange','cyan','green','grey','purple','brown']
for k in range(K):
    data=X[X["Cluster"]==k+1]
    plt.scatter(data["Data_3"],data["Data_1"],c=color[k])
plt.scatter(Centroids["Data_3"],Centroids["Data_1"],c='red')
plt.xlabel('Data Set 1')
plt.ylabel('Data Set 2')
plt.savefig('4.png')
