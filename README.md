#Hierarchical Agglomerative Clustering
==========
The Data Mining course project that required implementing HAC in 3-dimensional Euclidean space.

##Step 1
Generate a set S of 500 points (vectors) in 3-dimensional Euclidean space. Use the Euclidean distance to measure the distance between any two points. Write a program to find all the outliers in your set S and print out these outliers. If there is no outlier, your program should indicate so.
Next, remove the outliers from S, and call the resulting set S’.

##Step 2
Write a program that implements the hierarchical agglomerative clustering algorithm to cluster the points in S’ into k clusters where k is a user-specified parameter value.

In determining the distance of two clusters, you should consider the following definition respectively:
- the distance between the nearest two points in the two clusters
- the distance between the farthest two points in the two clusters
- the average distance between points in the two clusters
- the distance between the centers of the two clusters
Use the definition that yields the best performance.
