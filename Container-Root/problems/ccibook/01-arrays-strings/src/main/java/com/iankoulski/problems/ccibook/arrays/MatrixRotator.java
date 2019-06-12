package com.iankoulski.problems.ccibook.arrays;


//1.7 Rotate Matrix

/*
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

Hints:
#51: Think layer by layer. Can you rotate a specific layer?
#100: Rotating a specific layer would just mean swapping the values in four arrays. If you were asked to swap the values in two arryas, could you do this? Can you then extend it to four arrays?
*/

/*
Example:

N N N N N
N N N N N
N N N N N
N N N N N
N N N N N 

10 23 12 66 23           99 53 73 11 10      99 53 73 11 10      99 53 73 11 10
11 35 62 12 11           82          23      82 62 45 35 23      82 62 45 35 23
73 45 66 23 12    ->     45          12  ->  45 12    62 12  ->  45 12 66 62 12
53 62 12 67 83           31          66      31 67 23 12 66      31 67 23 12 66
99 82 45 31 64           64 83 12 11 23      64 83 12 11 23      64 83 12 11 23

int layers=matrix.length/2
int layer=0; layer<layers; layer++
int layerLength=matrix.length-2*layer-1
int i=0; i<layerLength; i++

Rotation Algo
i=0; i<layerLength; i++
temp=matrix[layer+i][layer];
matrix[layer+i][layer]=matrix[layer][matrix.length-1-layer-i]
matrix[layer][matrix.length-1-layer-i]=matrix[matrix.length-1-layer-i][matrix.length-1-layer]
matrix[matrix.length-1-layer-i][matrix.length-1-layer]=matrix[matrix.length-1-layer][layer+i]
matrix[matrix.length-1-layer][layer+i]=temp;

4 bytes = 4x8bits = 32bits => Each pixel can be stored in an int.

Due to the two nested loops, time complexity is O(N^2)
Due to doing the rotation in place, space complexity is O(1)
*/

public class MatrixRotator {
    
    public static void main( String[] args ){
        System.out.println("\n\nvvvvvvvvvvvvvvvvvv Matrix Rotator vvvvvvvvvvvvvvvvvvvvv\n");
/*         int[][] matrix = {{10,23,12,66,23},
                          {11,35,62,12,11},
                          {73,45,66,23,12},
                          {53,62,12,67,83},
                          {99,82,45,31,64}};
 */
        int[][] matrix = {{10,20,30,40,50,60},
                          {11,12,13,14,15,16},
                          {21,22,23,24,25,26},
                          {31,32,33,34,35,36},
                          {41,42,43,44,45,46},
                          {51,52,53,54,55,56}};
        
                  MatrixRotator mr = new MatrixRotator();
        System.out.println("Original matrix: \n" + matrixToString(matrix));
        boolean result=mr.rotate(matrix);
        System.out.println("Rotation result: " + result);
        System.out.println("Rotated matrix: \n" + matrixToString(matrix));
		System.out.println("\n^^^^^^^^^^^^^^^^^^ End Matrix Rotator ^^^^^^^^^^^^^^^^^^^^^\n\n");        
    }

    static String matrixToString(int[][] matrix){
        if (matrix.length == 0) return "";
        int width = matrix.length;
        int height = matrix[0].length;
        char space = ' ';
        StringBuilder sb = new StringBuilder(4*width*height + height); // assume numbers up to 3 digits + 1 space and height rows
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                sb.append(matrix[i][j]);
                sb.append(space);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    boolean rotate(int[][] matrix){
        if (matrix.length == 0){
            System.out.println("The matrix is empty, nothing to rotate.");
            return false;
        }
        if (matrix[0].length != matrix.length){
            System.out.println("Rotation is only supported for a square matrix");
            return false;
        }
        int layers = matrix.length/2;
        int temp=0;
        for (int layer=0; layer<layers; layer++){
            int layerLength = matrix.length-2*layer-1;
            for (int i=0; i<layerLength; i++){
                temp=matrix[layer][layer+i];
                matrix[layer][layer+i]=matrix[matrix.length-1-layer-i][layer];
                matrix[matrix.length-1-layer-i][layer] = 
                matrix[matrix.length-1-layer][matrix.length-1-layer-i];
                matrix[matrix.length-1-layer][matrix.length-1-layer-i] = 
                matrix[layer+i][matrix.length-1-layer];
                matrix[layer+i][matrix.length-1-layer]=temp;
            }
        }
        return true;
    }
}



