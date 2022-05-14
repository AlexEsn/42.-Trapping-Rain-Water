class Solution {

    public static int trap(int[] height) {

        int maxWaterBarIndex = 0, waterInTrap = 0, tempMax = 0;

        for (int i = 0; i < height.length; i++)
            maxWaterBarIndex = height[i] >= height[maxWaterBarIndex] ? i : maxWaterBarIndex;


        for (int i = 0; i <= maxWaterBarIndex; i++) {

            if (height[i] > tempMax)
                tempMax = height[i];

            waterInTrap += tempMax - height[i];
        }

        if(maxWaterBarIndex == height.length - 1) return waterInTrap;

        tempMax = 0;

        for (int i = height.length - 1; i > maxWaterBarIndex; i--) {

            if (height[i] > tempMax)
                tempMax = height[i];

            waterInTrap += tempMax - height[i];

        }

        return waterInTrap;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0, 2}));
    }
}