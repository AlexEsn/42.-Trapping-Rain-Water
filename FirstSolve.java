class Solution {

    public static int trap(int[] height) {

        int maxWaterBarIndex = 0;
        List<Integer> waterHeight = Arrays.stream(height).boxed().toList();

        for(int i = 0; i < height.length; i++)
            maxWaterBarIndex = height[i] >= height[maxWaterBarIndex] ? i : maxWaterBarIndex;

        if(maxWaterBarIndex != height.length - 1) {
            var leftWaterInTrap = new ArrayList<Integer>(waterHeight.subList(0, maxWaterBarIndex + 1));
            var rightWaterInTrap = new ArrayList<Integer>(waterHeight.subList(maxWaterBarIndex, waterHeight.size()));
            Collections.reverse(rightWaterInTrap);
            return  findWaterInTrap(leftWaterInTrap) + findWaterInTrap(rightWaterInTrap);
        }

        return findWaterInTrap(waterHeight);
    }

    private static int findWaterInTrap(List<Integer> height){

        int waterInTrap = 0, currentPosition = 0;
        Stack<Integer> waterBar = new Stack<>();

        int tempMax = height.get(currentPosition);
        waterBar.push(height.get(currentPosition));

        for (; currentPosition < height.size(); currentPosition++) {

            if (height.get(currentPosition) >= tempMax) {

                while (!waterBar.isEmpty())
                    waterInTrap += tempMax - waterBar.pop();

                tempMax = height.get(currentPosition);
            }

            waterBar.push(height.get(currentPosition));
        }

        return waterInTrap;
    }
}