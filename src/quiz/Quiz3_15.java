package quiz;

public class Quiz3_15 {

    static int mid(int x, int y, int z) {
        //Q1. 풀이방법
        // 다 같을 때
        if (x == y && x == z) return x;
        // 2개 같을 때
        if (x == y) return (x > z) ? z : x;
        if (x == z || y == z) return (x > y) ? y : x;
        // 다 다를 때
        if (x > y && x > z) return (y > z) ? y : z;
        if (x < y && x < z) return (y < z) ? y : z;
        return x;
    }

    int bingCnt(int[][] arr) {
        // 내부 첫번째 배열을 읽는다.
        // 0이 존재하면 읽는 것을 중지한다.
        // (추가) n행m열의 마지막 열이 아닌 1의 값은 그냥 넘어간다.
        // 1이 있어서 끝까지 읽을 때 숫자 1을 더해준다.
        // 내부 배열을 다 읽으면 count한 것을 반환한다.

        int count =0;

        for (int i = 0; i < arr.length; i++) {
            // 가로
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) break;
                if (j<arr.length-1) continue;
                if (arr[i][arr.length-1]==1) count++;
            }
            // 세로
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == 0) break;
                if (j <arr.length-1) continue;
                if (arr[arr.length-1][i]==1) count++;
            }
        }

        int crossCountDown = 0;
        int crossCountUp = 0;

        // 대각선
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][i]==1) crossCountDown++;
            if(arr[i][arr.length-1-i]==1) crossCountUp++;
        }
        count += crossCountDown/arr.length + crossCountUp/arr.length;

        // 결과
        return count;
    }
    public static void main(String[] args) {
    } // quiz main 끝
} // quiz class 끝
