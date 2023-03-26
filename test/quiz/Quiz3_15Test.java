package quiz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // test method _ 언더스코어 제거하는 코드
@DisplayName("2번째로 큰 값과 빙고 개수 맞추기 test")
class Quiz3_15Test {

    int mid(int x, int y, int z) {
        //Q1. 풀이방법
        // 다 같을 때
        if(x == y && x == z) return x;
        // 2개 같을 때
        if (x == y) return (x > z) ? z : x;
        if (x == z || y == z) return (x > y) ? y : x;
        // 다 다를 때
        if (x > y && x > z ) return (y > z)? y : z;
        if (x < y && x < z ) return (y < z)? y : z;
        return x;

    }

    int bingCnt(int[][] arr) {
        // 내부 첫번째 배열을 읽는다.
        // 0이 존재하면 읽는 것을 중지한다.
        // (추가) n행m열의 마지막 열이 아닌 1의 값은 그냥 넘어간다.
        // 1이 있어서 끝까지 읽을 때 숫자 1을 더해준다.
        // 내부 배열을 다 읽으면 count한 것을 반환한다.

        int count =0;
        int crossCountDown = 0;
        int crossCountUp = 0;
        for (int i = 0; i < arr.length; i++) {
            int garo = 0;
            int sero = 0;
            for (int j = 0; j < arr.length; j++) {
                garo += arr[i][j];
                sero += arr[j][i];
                if (garo == 5) count++;
                if (sero == 5) count++;

            }
                crossCountDown += arr[i][i];
                crossCountUp += arr[i][arr.length-1-i];
                if (crossCountDown ==5) count++;
                if (crossCountUp ==5) count++;

        }

        // 결과
        return count;
    }

    @DisplayName("동일한 숫자 3개일 때 2번째로 큰 값")
    @Test
    void quiz1_AllSameNum() {
        assertEquals(1, mid(1, 1, 1));
    }
    @DisplayName("동일한 숫자 2개일 때 2번째로 큰 값")
    @Test
    void quiz1_TwoSameNum() {
        assertEquals(1, mid(1, 1, 2));
        assertEquals(1, mid(2, 2, 1));
        assertEquals(1, mid(2, 1, 2));
        assertEquals(1, mid(1, 2, 1));
    }
    @DisplayName("동일한 숫자 없을 때 2번째로 큰 값")
    @Test
    void quiz1_NotSameNum() {
        assertEquals(2, mid(1, 2, 3));
        assertEquals(2, mid(1, 3, 2));
        assertEquals(2, mid(2, 1, 3));
        assertEquals(2, mid(2, 3, 1));
        assertEquals(2, mid(3, 1, 2));
        assertEquals(2, mid(3, 2, 1));
    }


    @Test
    @DisplayName("모든 0이거나 1인 빙고")
    void quiz2_One_Zeo() {
        //1 과 0
        int[][] bing = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        }; //12
        int[][] bing1 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        }; //0
        assertEquals(12, bingCnt(bing));
        assertEquals(0, bingCnt(bing1));
    }
    @DisplayName("가로 빙고")
    @Test
    void quiz2_Column() {
        // 가로
        int[][] bing2 = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        }; //1
        int[][] bing3 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
        }; //1
        int[][] bing4 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        }; //1
        assertEquals(1, bingCnt(bing2));
        assertEquals(1, bingCnt(bing3));
        assertEquals(1, bingCnt(bing4));
    }
    @DisplayName("세로 빙고")
    @Test
    void quiz2_Row() {
        // 세로
        int[][] bing5 = {
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
        }; //1
        int[][] bing6 = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
        }; //1
        int[][] bing7 = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
        }; //1
        assertEquals(1, bingCnt(bing5));
        assertEquals(1, bingCnt(bing6));
        assertEquals(1, bingCnt(bing7));
    }
    @DisplayName("대각선 빙고")
    @Test
    void quiz2_Cross() {
        // 대각선
        int[][] bing8 = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
        }; //11
        int[][] bing9 = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
        }; //1
        int[][] bing10 = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
        }; //2
        assertEquals(1, bingCnt(bing8));
        assertEquals(1, bingCnt(bing9));
        assertEquals(2, bingCnt(bing10));
    }
    @DisplayName("렌덤 숫자가 들어간 빙고")
    @Test()
    void quiz2_Random() {
        // 렌덤
        int[][] bing11 = {
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 1},
        }; // 3
        int[][] bing12 = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 1},
        }; //4
        int[][] bing13 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
        }; //4
        int[][] bing14 = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
        }; // 6
        assertEquals(3, bingCnt(bing11));
        assertEquals(4, bingCnt(bing12));
        assertEquals(4, bingCnt(bing13));
        assertEquals(6, bingCnt(bing14));
    }
}