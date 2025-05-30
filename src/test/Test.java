package test;

import java.io.File;
import tensor.*;

import static java.lang.Integer.*;


public class Test {
    public static void main(String[] args) {
            // [1] 스칼라 생성 및 연산
            System.out.println("[1] 스칼라 생성 및 연산");

            // 01. 스칼라1 지정 생성(지정값 : 3)
            String scalar1_value = "3"; // 사용자 지정 값
            Scalar scalar1 = Factory.getScalar(scalar1_value);
            if("3".equals(scalar1.toString())) {
                System.out.println("스칼라1 생성 성공 (01)");
            } else { System.out.println("스칼라1 생성 실패(01)"); }

            // 01. 스칼라2 지정 생성(지정값 : 4)
            String scalar2_value = "4"; // 사용자 지정 값
            Scalar scalar2 = Factory.getScalar(scalar2_value);
            if("4".equals(scalar2.toString())) {
            System.out.println("스칼라2 생성 성공 (02)");
            } else { System.out.println("스칼라2 생성 실패(02)"); }

            // 02. 스칼라3 랜덤 생성(1~9중 랜덤값)
            int randMin_s=1,randMax_s=10; // 사용자 지정 값
            Scalar scalar3 = Factory.getScalar(randMin_s,randMax_s);
            System.out.println("스칼라3(값 : " + scalar3.getScalar() + ") 생성 (02)");
            if(parseInt(String.valueOf(scalar3)) >= 1 && parseInt(String.valueOf(scalar3)) < 10){
                System.out.println("스칼라3(값 : " + scalar3.getScalar() + ") 생성 성공 (02)");
            } else {
                System.out.println("스칼라3 생성 실패 (02");
            }

            // 17. 스칼라1 복제
            Scalar scalar1_1 = scalar1.cloneSelf();
            if("3".equals(scalar1_1.toString())) {
                System.out.println("스칼라1-1에 스칼라1 복제 성공(17) -> " + scalar1_1);
            } else {
                System.out.println("스칼라1-1에 스칼라1 복제 실패(17) ");
            }


            // 16. 스칼라1 스칼라2 비교
            int comparedvalue = scalar1.compareWith(scalar2);
            System.out.println("스칼라1과 스칼라2의 비교 결과: " + comparedvalue + " (16)");
            if(comparedvalue<0){
                System.out.println("스칼라1과 스칼라2의 비교 결과 (성공): " + comparedvalue + " (16)");
            } else {
                System.out.println("스칼라1과 스칼라2 비교 실패 (16)");
            }

            // 15. 스칼라1 스칼라2 동등성 비교
            boolean isEqual = scalar1.equals(scalar2);
            if(false == isEqual) {
                System.out.println("스칼라1과 스칼라2 동등성 비교 성공 /결과: " + isEqual + " (15)");
            } else {
                System.out.println("스칼라1과 스칼라2 동등성 비교 실패 (15)");
            }

            // 14. 스칼라1 출력
            System.out.println("스칼라1 출력: " + scalar1 + " (14)");

            // 12. 스칼라1 지정 및 조회
            System.out.println("스칼라1 값 조회: " + scalar1.getScalar() + " (12)");
            String scalarValue = "5";
            scalar1.setScalar(scalarValue);
            if ("5".equals(scalar1.getScalar().toString())){
                System.out.println("스칼라1 값을 5로 변경 후 조회 성공: " + scalar1.getScalar() + " (12)");
            } else {
                System.out.println("스칼라1 값을 5로 변경 후 조회 실패 (12)");
            }

            // 24. 스칼라1 스칼라2 덧셈
            Scalar tempscalar = Tensors.addScalarEach(scalar1, scalar2);
            if("9".equals(tempscalar.toString())){
            System.out.println("스칼라1 + 스칼라2 성공 :" + tempscalar + " (24)"); //scalar1에 scalar2의 값을 더한 것을 출력함.
            } else {
            System.out.println("스칼라1 + 스칼라2 실패 (24)");
            }

            // 25. 스칼라1 스칼라2 곱셈
            Scalar tempscalar2 = Tensors.multiplyScalarEach(scalar1, scalar2);
            if("20".equals(tempscalar2.toString())) {
                System.out.println("스칼라1 * 스칼라2 성공" + tempscalar2 + " (25)"); //scalar1에 scalar2의 값을 곱한 것을 출력함.
            } else {
                System.out.println("스칼라1 * 스칼라2 실패 (25)");
            }

            // 18. 스칼라1에 스칼라2 더해서 저장
            scalar1.addScalar(scalar2);
            if ("9".equals(scalar1.toString())) {
                System.out.println("스칼라1에 스칼라2 더해서 저장 성공 : " + scalar1 + " (18)");
            } else {
                System.out.println("스칼라1에 스칼라2 더해서 저장 실패 (18)");
            }

            // 19. 스칼라2에 스칼라3 곱해서 저장
            scalar2.multiplyScalar(scalar3);
        if(parseInt(String.valueOf(scalar2)) >= 4 && parseInt(String.valueOf(scalar3)) < 40){
            System.out.println("스칼라2에 스칼라3 곱해서 저장 성공: " + scalar3.getScalar() + " (19)");
        } else {
            System.out.println("스칼라2에 스칼라3 곱해서 저장 실패 (19)");
        }

            System.out.println();

            // [2] 벡터 생성 및 연산
            System.out.println("[2] 벡터 생성 및 연산");

            // 05. 벡터1 1차원 배열로 3차원 벡터 생성(값: 1, 2, 3)
            int[] arr1 = {1, 2, 3};
            Vector vector1 = Factory.getVector(arr1, 3);
            System.out.println("벡터1 1차원 배열로 3차원 벡터 생성 (05)");

            // 03. 벡터2 0을 요소로 하는 2차원 벡터 생성
            Scalar zero = Factory.getScalar("0");
            Vector vector2 = Factory.getVector(zero, 2);
            System.out.println("벡터2 0을 요소로 하는 2차원 벡터 생성 (03)");

            // 04. 벡터3 1~9까지 랜덤 요소로 3차원 벡터 생성
            int rand1 = (int)(Math.random() * 9) + 1;
            int rand2 = (int)(Math.random() * 9) + 1;
            Vector vector3 = Factory.getVector(rand1, rand2, 3);
            System.out.println("벡터3 1~9까지 랜덤 요소로 3차원 벡터 생성 (04)");

            // 11. 벡터1 0번째 인덱스 요소 조회
            Scalar element0 = vector1.getAt(0);
            System.out.println("벡터1 0번째 인덱스 요소 조회: " + element0.getScalar() + " (11)");

            // 13. 벡터1 크기 정보(차원) 조회
            int vector1Size = vector1.size();
            System.out.println("벡터1 크기 정보 조회: " + vector1Size + " (13)");

            // 26. 벡터1 벡터2 덧셈
            Vector tempVector = Tensors.addVectorEach(vector1, vector2);
            System.out.println("벡터1에 벡터2 더한 결과: " + tempVector + " (26)");

            //27. 벡터1 벡터2 곱셈
            // Vector tempVector2 = Tensors.multiplyVectorScalar(vector1, vector2);

            // 20. 벡터1에 벡터3 더해서 저장 (크기가 같은 벡터끼리만 가능)
            try {
                vector1.addVector(vector3);
                System.out.println("벡터1에 벡터3 더해서 저장 완료 -> " + vector3 + " (20)");
            } catch (Exception e) {
                System.out.println("벡터1에 벡터3 더하기 실패 (크기 불일치): " + e.getMessage());
            }

            // 21. 벡터2에 스칼라2 곱해서 저장
            vector2.multiplyScalar(scalar2);
            System.out.println("벡터2에 스칼라2 곱해서 저장 완료 -> " + vector2 + " (21)");

            System.out.println();

            // [3] 벡터 -> 행렬 전환
            System.out.println("[3] 벡터 -> 행렬 전환");

            // 30. 벡터1을 행렬로 전환 (3*1 행렬)
            Matrix matrixFromVector1 = vector1.getRow(0);
            System.out.println("벡터1을 행렬로 전환 (3*1 행렬) (30)");

            // 31. 벡터1을 행렬로 전환 (1*3 행렬)
            Matrix matrixFromVector2 = vector1.getColumn(0);
            System.out.println("벡터1을 행렬로 전환 (1*3 행렬) (31)");
            System.out.println();

            // [4] 행렬 생성 및 연산
            System.out.println("[4] 행렬 생성 및 연산");

            // 09. 행렬1 2차원 배열로 생성(값 : {1 2} {3 4})
            int[][] matrix1_array = {{1, 2}, {3, 4}}; // 사용자 지정 값
            int row = 2, col = 2 ; //사용자 지정 값
            Matrix matrix1 = Factory.getMatrix(matrix1_array, row , col);
            if(("1 2\n3 4".equals(matrix1.toString()))){
                System.out.println("행렬1 2차원 배열로 생성 성공 :" +  matrix1 + "(09)");
            } else {
                System.out.println("행렬1 2차원 배열로 생성 실패 (09)");
            }

            // 08. 행렬2 csv 파일로 생성 (파일이 있다고 가정)
            File csvFile = new File("matrix_data.csv");
            Matrix matrix2 = Factory.getMatrix(csvFile, 3, 3);
            if(("5 6 7\n8 9 10\n11 12 13".equals(matrix2.toString()))){
                System.out.println("행렬2 csv파일로 생성 성공 :" +  matrix2 + "(08)");
            } else {
                System.out.println("행렬2 csv파일로 생성 실패 (08)");
            }


            // 06. 행렬3 0으로만 구성된 2*2 행렬 생성
            int row3= 2, col3=2;//사용자 설정 값
            String matrix3_value = "0"; //사용자 설정 값
            Scalar zeroScalar = Factory.getScalar(matrix3_value);
            Matrix matrix3 = Factory.getMatrix(zeroScalar, row3, col3);
        if(("0 0\n0 0".equals(matrix3.toString()))){
            System.out.printf("행렬3 %s으로만 구성된 %d*%d 행렬 생성 성공 :" +  matrix3 + "(06)" ,matrix3_value, row, col);
        } else {
            System.out.printf("행렬3 %s으로만 구성된 %d*%d 행렬 생성 실패 (06)",matrix3_value, row, col);
        }

            // 07. 행렬4 랜덤(1~9) 2*2 생성
            int randMin_m=1, randMax_m=10, row4 = 2, col4 = 2;  //사용자 설정 값
            Matrix matrix4 = Factory.getMatrix(randMin_m,randMax_m,row4, col4);

            if(matrix4.size("row") == row4 && matrix4.size("col") == col4) //사이즈 비교
            {
                boolean flag=true;
                for(int i=0;i<row4;i++){ //값이 유효한 범위 안인지 비교
                    for(int j=0;j<col4;j++) //값이 유효한 범위 안인지 비교
                    {
                        Scalar nowVal = matrix4.getMatrixAt(i, j);
                        if(randMin_m>Integer.parseInt(nowVal.toString()) || randMax_m<Integer.parseInt(nowVal.toString()))
                        {
                            flag=false;
                            System.out.println("실패.");
                            break;
                        }
                    }
                }

                if(flag)
                {
                    System.out.printf("행렬4 랜덤(%d~%d) %d*%d 생성 성공 (07)\n", randMin_m,randMax_m-1,row4,col4);
                }
            } else {
                System.out.printf("행렬4 랜덤(%d~%d) %d*%d 생성 실패 (07)\n", randMin_m,randMax_m-1,row4,col4);
            }

            // 28. 행렬1과 행렬4 덧셈
            try {
                Matrix result_1plus4 = Tensors.addMatrixEach(matrix1, matrix4);
                if(result_1plus4.size("row") == row4 && result_1plus4.size("col") == col4) //사이즈 비교
                {
                    boolean flag=true;
                    for(int i=0;i<row4;i++){ //값이 유효한 범위 안인지 비교
                        for(int j=0;j<col4;j++) //값이 유효한 범위 안인지 비교
                        {
                            Scalar nowVal = result_1plus4.getMatrixAt(i, j);
                            Scalar addVal = matrix1.getMatrixAt(i,j);

                            if(randMin_m+Integer.parseInt(addVal.toString())>Integer.parseInt(nowVal.toString()) || randMax_m+Integer.parseInt(addVal.toString())<Integer.parseInt(nowVal.toString()))
                            {
                                flag=false;
                                System.out.println("실패.");
                                break;
                            }
                        }
                    }

                    if(flag)
                    {
                        System.out.println("행렬1 행렬4 덧셈 성공 (28)");
                    }
                } else {
                    System.out.println("행렬1 행렬4 덧셈 실패 (28)");
                }
            } catch (Exception e) {
                System.out.println("행렬1과 행렬4 덧셈 실패(28): " + e.getMessage());
            }
            // 29. 행렬1과 행렬3 곱셈
            try {
                Matrix result_1multi3 = Tensors.multiplyMatrixEach(matrix1, matrix3);
                if(("0 0\n0 0".equals(result_1multi3.toString()))){
                    System.out.println("행렬1과 행렬3 곱셈 성공 : "+  result_1multi3 +"(29)");
                } else {
                    System.out.println("행렬1과 행렬3 곱셈 실패 (29)");
                }
            } catch (Exception e) {
                System.out.println("행렬1과 행렬3 곱하기 실패: " + e.getMessage());
            }

            // 22. 행렬1에 행렬3 더해서 저장
            try {
                matrix1.addMatrix(matrix3);
                if(("1 2\n3 4".equals(matrix1.toString()))){
                    System.out.println("행렬1에 행렬3 더해서 저장 성공 : "+  matrix1 +"(22)");
                } else {
                    System.out.println("행렬1과 행렬3 더해서 저장 실패 (22)");
                }
            } catch (Exception e) {
                System.out.println("행렬1에 행렬3 더해서 저장 실패: " + e.getMessage());
            }

            // 23. 행렬3에 행렬1 곱해서 저장
            String multiplyDirection = "right";//사용자 지정 값
            try {
                matrix3.multiplyMatrix(matrix1, multiplyDirection); //m * 기존행렬
                if(("0 0\n0 0".equals(matrix3.toString()))){
                    System.out.println("행렬3에 행렬1 곱해서 저장 성공 : "+  matrix3 +"(23)");
                } else {
                    System.out.println("행렬3에 행렬1 곱해서 저장 실패 (23)");
                }
            } catch (Exception e) {
                System.out.println("행렬3에 행렬1 곱해서 저장 실패: " + e.getMessage());
            }

            // 39. 행렬3 대각 요소의 합 구하기
            try {
                Scalar trace = matrix3.getTrace();
                if("0".equals(trace.toString())) {
                    System.out.println("행렬3 대각 요소의 합 구하기 성공: " + trace.getScalar() + " (39)");
                } else {
                    System.out.println("행렬3 대각 요소의 합 구하기 실패 (39)");
                }
            } catch (Exception e) {
                System.out.println("행렬3 대각합 구하기 실패 (39): " + e.getMessage());
            }

            System.out.println();

            // [5] 행렬 행/열 조작
            System.out.println("[5] 행렬 행/열 조작");

            // 45. 행렬1 1행과 2행 교환
            matrix1.swapRow(0, 1); // 0-based 인덱스 사용
            if("3 4\n1 2".equals(matrix1.toString())) {
                System.out.println("행렬1 1행과 2행 교환 성공 (45)");
            } else {
                System.out.println("행렬1 1행과 2행 교환 실패(45)");
            }

            // 46. 행렬1 1열과 2열 교환
            matrix1.swapColumn(0, 1);
            if("4 3\n2 1".equals(matrix1.toString())) {
                System.out.println("행렬1 1열과 2열 교환 성공 (46)");
            } else {
                System.out.println("행렬1 1열과 2열 교환 실패 (46)");
            }
            // 38. 행렬1 전치행렬 생성
            Matrix transpose = matrix1.getTranspose();
            if("1 3\n2 4".equals(transpose.toString())) {
                System.out.println("행렬1 전치행렬 생성 완료"+transpose+"(38)");
            }else {
                System.out.println("행렬1 전치행렬 생성 실패 (38)");
            }
            // 15m. 행렬1과 행렬1전치행렬 동등성 판단
            boolean isTransposeEqual = matrix1.equals(transpose);
            if(false == isTransposeEqual) {
                System.out.println("행렬1과 전치행렬 동등성 판단 성공: " + isTransposeEqual + " (15m)");
            } else {
                System.out.println("행렬1과 전치행렬 동등성 판단 실패 (15m)");
            }

            System.out.println();

            // [6] 행렬 구조 추출 및 결합
            System.out.println("[6] 행렬 구조 추출 및 결합");

            // 34. 행렬1의 1행 벡터 형태로 추출
            Vector row1 = matrix1.extractMatrixToVector(0, "row");
            System.out.println("행렬1의 1행 벡터 형태로 추출 완료 (34)");

            // 34. 행렬1의 2행 벡터 형태로 추출
            Vector row2 = matrix1.extractMatrixToVector(1, "row");
            System.out.println("행렬1의 2행 벡터 형태로 추출 완료 (34)");

            // 31. 추출한 행 벡터들을 행렬로 전환

            Matrix matrixFromRow1 = row1.getColumn(0);
            Matrix matrixFromRow2 = row2.getColumn(0);
            System.out.println("추출한 행 벡터들을 행렬로 전환 완료 (31)");

            // 33. 행렬끼리 세로로 합치기
            try {
                matrixFromRow1.connectMatrix(matrixFromRow2, "vertical");
                System.out.println("행렬끼리 세로로 합치기 완료 (33)");
            } catch (Exception e) {
                System.out.println("세로 합치기 실패: (33)" + e.getMessage());
            }

            // 35. 행렬1의 열 벡터 형태로 추출
            Vector col1 = matrix1.extractMatrixToVector(0, "column");
            Vector col2 = matrix1.extractMatrixToVector(1, "column");
            System.out.println("행렬1의 열 벡터들 추출 완료 (35)");

            // 30. 추출한 열 벡터들을 행렬로 전환
            Matrix matrixFromCol1 = col1.getRow(0);
            Matrix matrixFromCol2 = col2.getRow(0);
            System.out.println("추출한 열 벡터들을 행렬로 전환 완료 (30)");

            // 32. 행렬끼리 가로로 합치기
            try {
                matrixFromCol1.connectMatrix(matrixFromCol2, "horizontal");
                System.out.println("행렬끼리 가로로 합치기 완료 (32)");
            } catch (Exception e) {
                System.out.println("가로 합치기 실패: (32)" + e.getMessage());
            }

            System.out.println();

            // [7] RREF와 역행렬 구하기
            System.out.println("[7] RREF와 역행렬 구하기");

            // 51. 행렬2 RREF 구하기
            System.out.println("행렬2 RREF 구하기 시작:");

            // 14m. 행렬2 출력 (toString이 없어서 크기 정보만)
            System.out.println("행렬2 현재 상태 출력 (14m)");

            // 13m. 행렬2 크기 정보 조회
            int rows = matrix2.size("row");
            int cols = matrix2.size("column");
            System.out.println("행렬2 크기: " + rows + "x" + cols + " (13m)");

            // 10. 단위행렬 생성
            Matrix identityMatrix = Factory.getMatrix(rows); // n*n 단위행렬
            System.out.println("단위행렬 생성 완료 (10)");

            // RREF 과정 시뮬레이션 (실제로는 getRREF() 사용)
            System.out.println("RREF 연산 과정:");

            // 45-50번 연산들 중 하나씩 수행하며 RREF 판단
            // 실제 구현에서는 알고리즘에 따라 적절한 연산 선택

            // 예시: 47. 특정행에 상수배
            try {
                matrix2.multiplyByScalar(Factory.getScalar("2"), "row");
                System.out.println("연산결과출력 (47)");
                identityMatrix.multiplyByScalar(Factory.getScalar("2"), "row");

                // 52. RREF 판단
                boolean isRREF = matrix2.isRREF();
                System.out.println("행렬2 " + (isRREF ? "is RREF" : "is not RREF") + " (52)");

            } catch (Exception e) {
                System.out.println("RREF 연산 중 오류: " + e.getMessage());
            }

            // 최종 RREF 구하기
            try {
                Matrix rrefMatrix = matrix2.getRREF();
                System.out.println("최종 RREF 구하기 완료 (51)");

                // 54. 역행렬 구하기
                Matrix inverse = matrix2.getReversed();
                System.out.println("역행렬 구하기 완료 (54)");

            } catch (Exception e) {
                System.out.println("RREF/역행렬 구하기 실패: " + e.getMessage());
            }

            System.out.println();

            // [8] RREF로 구한 값의 특징 판단
            System.out.println("[8] RREF 특징 판단");

            try {
                Matrix rrefResult = matrix2.getRREF();

                // 40. 정사각 행렬인지
                boolean isSquare = rrefResult.isSquareMatrix();
                System.out.println("RREF가 정사각 행렬인지: " + isSquare + " (40)");

                // 41. 상삼각 행렬인지
                boolean isUpper = rrefResult.isUpperTriangularMatrix();
                System.out.println("RREF가 상삼각 행렬인지: " + isUpper + " (41)");

                // 42. 하삼각 행렬인지
                boolean isLower = rrefResult.isLowerTriangularMatrix();
                System.out.println("RREF가 하삼각 행렬인지: " + isLower + " (42)");

                // 43. 단위 행렬인지
                boolean isIdentity = rrefResult.isIdentityMatrix();
                System.out.println("RREF가 단위 행렬인지: " + isIdentity + " (43)");

                // 44. 영 행렬인지
                boolean isZero = rrefResult.isZeroMatrix();
                System.out.println("RREF가 영 행렬인지: " + isZero + " (44)");

            } catch (Exception e) {
                System.out.println("RREF 특징 판단 중 오류: " + e.getMessage());
            }

            System.out.println();

            // [9] 행렬식 구하기
            System.out.println("[9] 행렬식 구하기");

            // 53. 행렬식 구하기
            // 14m. 행렬1 크기 정보 조회
            int matrix1Rows = matrix1.size("row");
            int matrix1Cols = matrix1.size("column");
            System.out.println("행렬1 크기: " + matrix1Rows + "x" + matrix1Cols + " (14m)");

            if (matrix1Rows == matrix1Cols) { // 정사각행렬인 경우
                try {
                    if (matrix1Rows == 2) {
                        // 2x2 행렬식 계산: (1,1)*(2,2) - (1,2)*(2,1)
                        // 11m. 특정 위치 요소 조회
                        Scalar a11 = matrix1.getMatrixAt(0, 0);
                        Scalar a12 = matrix1.getMatrixAt(0, 1);
                        Scalar a21 = matrix1.getMatrixAt(1, 0);
                        Scalar a22 = matrix1.getMatrixAt(1, 1);

                        System.out.println("2x2 행렬식 수동 계산:");
                        System.out.println("a11: " + a11.getScalar() + ", a12: " + a12.getScalar());
                        System.out.println("a21: " + a21.getScalar() + ", a22: " + a22.getScalar());

                        // 19. 스칼라끼리 곱셈ㅇ
                        Scalar term1 = a11.cloneSelf();
                        term1.multiplyScalar(a22);

                        Scalar term2 = a12.cloneSelf();
                        term2.multiplyScalar(a21);

                        Scalar minusOne = Factory.getScalar("-1");
                        term2.multiplyScalar(minusOne);

                        // 18. 스칼라끼리 덧셈
                        term1.addScalar(term2);

                        System.out.println("수동 계산된 행렬식: " + term1.getScalar());
                    }

                    // 53. 행렬식 구하기 (라이브러리 메소드)
                    Scalar determinant = matrix1.getDeterminant();
                    System.out.println("라이브러리로 구한 행렬식: " + determinant.getScalar() + " (53)");

                } catch (Exception e) {
                    System.out.println("행렬식 계산 실패: " + e.getMessage());
                }
            } else {
                System.out.println("정사각행렬이 아니므로 행렬식을 구할 수 없습니다.");
            }

            System.out.println();

            // 예외처리 테스트
            System.out.println("[예외처리 테스트]");

            // 크기가 같지 않은 두 벡터 덧셈 시도
            try {
                vector1.addVector(vector2); // 3차원 + 2차원
                System.out.println("벡터 덧셈 성공 (예상외)");
            } catch (VectorSumSizeMismatch e) {
                System.out.println("벡터 덧셈 크기 불일치 예외 발생: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("벡터 덧셈 기타 예외: " + e.getMessage());
            }

            // 크기가 맞지 않는 행렬 곱셈 시도
            try {
                matrix1.multiplyMatrix(matrix2, "left"); // 2x2 * 3x3
                System.out.println("행렬 곱셈 성공 (예상외)");
            } catch (MatrixMultiplySizeMismatch e) {
                System.out.println("행렬 곱셈 크기 불일치 예외 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("행렬 곱셈 기타 예외: " + e.getMessage());
            }

            // 행수가 다른 두 행렬을 가로로 합치기 시도
            try {
                matrix1.connectMatrix(matrix2, "horizontal"); // 2x2와 3x3
                System.out.println("가로 합치기 성공 (예상외)");
            } catch (MatrixColumnSizeMismatch e) {
                System.out.println("가로 합치기 행수 불일치 예외 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("가로 합치기 기타 예외: " + e.getMessage());
            }

            System.out.println("\n=== 모든 테스트 완료 ===");

        }
}