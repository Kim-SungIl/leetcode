class Solution {
    // 이 문제는 Programers의 정수 삼각형 문제를 max 대신 min으로 치환한 문제와 같다. (https://programmers.co.kr/learn/courses/30/lessons/43105)
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int [][] triangleArray = new int[length][length];
        int row = 0;
        for (List<Integer> list : triangle){
            int col = 0;
            for (Integer val : list){
                triangleArray[row][col++] = val;
            }
            row++;
        }
        
        int[][] dpArray = new int[length+1][length+1];
        // dpArray 내부 값을 최대 값으로 채운 후 시작
        for (int i = 1; i< length + 1 ; i++){
            for (int j = 0; j < length +1; j++){
                dpArray[i][j] = 10001;
            }
        }
        for (int i = 1; i<length + 1; i++){
            for (int j = 1; j<i + 1; j++){
                dpArray[i][j] = Math.min(dpArray[i-1][j] + triangleArray[i-1][j-1], dpArray[i-1][j-1] + triangleArray[i-1][j-1]);
            }
        }
        int answer = 10001;
        for (int i = 0; i<length + 1; i ++){
            answer = Math.min(answer, dpArray[length][i]);
        }
            
        return answer;
    }
}
