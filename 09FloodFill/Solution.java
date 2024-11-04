class Solution {
    /* Clarify
    given int[i][j] grid representing pixels in an image
    [i] row, [j] column, values for color
    given two ints for the starting pixel position
    given int to represent color
    flood fill: 
        1) change the starting pixel to the given color
        2) change any adjacent (vertical/horizontal) pixel to given color if it matches the original color (paint fill)
        3) repeat the process of each neighboring pixel until there are no more adjacent pixels of the original color
    return the modified image
    */

    /* Approach
    if statement checks given color = starting pixel color
        return image
    recursively iterate through grid
    create helper method with new param for the original color
    if statement checks pixel out of bounds || is not original color
        return
    set current pixel to new color
    recursive call to check the left
    recursive call to check the right
    recursive call to check above
    recursive call to check below
    return image
    uses DFS by recursively visiting all pixels in one direction first
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]) {
            return image;
        }
        fill(image,sr,sc,image[sr][sc],color);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int ogColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != ogColor) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image,sr - 1,sc,ogColor,newColor);
        fill(image,sr + 1,sc,ogColor,newColor);
        fill(image,sr,sc - 1,ogColor,newColor);
        fill(image,sr,sc + 1,ogColor,newColor);
    }
    /* Test
    Input: image = [[1,1,1],
                    [1,1,0],
                    [1,0,1]], sr = 1, sc = 1, color = 2
    [1,1,1]    [1,1,1]    [2,1,1]    [2,2,1]    Output: [2,2,2]
    [1,2,0] >> [2,2,0] >> [2,2,0] >> [2,2,0] >>         [2,2,0]
    [1,0,1]    [1,0,1]    [1,0,1]    [1,0,1]            [2,0,1]

    Input: image = [[0,0,0],
                    [0,0,0]], sr = 0, sc = 0, color = 0
    Output: [0,0,0]
            [0,0,0]
    */

    /* Optimize
    O(m*n) runtime, iterates recursively based on given 2d grid
    O(1) space, no additional data structures created
    */
}