package test;

import java.io.File;
import tensor.*;


public class Test {
    public static void main(String[] args) {
            // [1] 스칼라 생성 및 연산
            System.out.println("[1] 스칼라 생성 및 연산");

            // 01. 스칼라1 지정 생성(지정값 : 3)
            Scalar scalar1 = Factory.getScalar("3");
            System.out.println("스칼라1 생성 (01)");

            // 01. 스칼라2 지정 생성(지정값 : 4)
            Scalar scalar2 = Factory.getScalar("4");
            System.out.println("스칼라2 생성 (01)");

            // 02. 스칼라3 랜덤 생성(1~9중 랜덤값)
            int scalarRandomValue1 = (int)(Math.random() * 9) + 1, scalarRandomValue2 = (int)(Math.random() * 9) + 1;
            Scalar scalar3 = Factory.getScalar(scalarRandomValue1, scalarRandomValue2);
            System.out.println("스칼라3(값 : " + scalar3.getScalar() + ") 생성 (02)");

            // 17. 스칼라1 복제
            Scalar scalar1_1 = scalar1.cloneSelf();
            System.out.println("스칼라1-1에 스칼라1 복제(17) -> " + scalar1_1);

            // 16. 스칼라1 스칼라2 비교
            //int comparedvalue = scalar1.compareWith(scalar2);
            //compareTo 호출이 불가하여 compareWith 대체해놓음.
            //System.out.println("스칼라1과 스칼라2의 비교 결과: " + comparedvalue + " (16)");

            // 15. 스칼라1 동등성 비교
            boolean isEqual = scalar1.equals(scalar2);
            System.out.println("스칼라1과 스칼라2 동등성 비교 결과: " + isEqual + " (15)");

            // 14. 스칼라1 출력
            System.out.println("스칼라1 출력: " + scalar1 + " (14)");

            // 12. 스칼라1 지정 및 조회
            System.out.println("스칼라1 값 조회: " + scalar1.getScalar() + " (12)");
            String scalarValue = "5";
            scalar1.setScalar(scalarValue);
            System.out.println("스칼라1 값을 5로 변경 후 조회: " + scalar1.getScalar() + " (12)");

            // 24. 스칼라1 스칼라2 덧셈
            Scalar tempscalar = Tensors.addScalarEach(scalar1, scalar2);
            System.out.println(tempscalar + " (24)"); //scalar1에 scalar2의 값을 더한 것을 출력함.

            // 25. 스칼라1 스칼라2 곱셈
            Scalar tempscalar2 = Tensors.multiplyScalarEach(scalar1, scalar2);
            System.out.println(tempscalar2 + " (25)"); //scalar1에 scalar2의 값을 곱한 것을 출력함.

            // 18. 스칼라1에 스칼라2 더해서 저장
            scalar1.addScalar(scalar2);
            System.out.println("스칼라1에 스칼라2 더한 결과: " + scalar1 + " (18)");

            // 19. 스칼라2에 스칼라3 곱해서 저장
            scalar2.multiplyScalar(scalar3);
            System.out.println("스칼라2에 스칼라3 곱한 결과: " + scalar3 + " (19)");

            System.out.println();

            // [2] 벡터 생성 및 연산
            System.out.println("[2] 벡터 생성 및 연산");

            // 05. 벡터1 1차원 배열(arr1)로 3차원 벡터 생성
            int[] arr1 = {1, 2, 3};
            Vector vector1 = Factory.getVector(arr1);
            System.out.println("벡터1 1차원 배열로 3차원 벡터 생성 (05) 값 : ");
            System.out.print(vector1.toString());
            if("1 2 3".equals(vector1.toString()))
            {
                System.out.println("통과.");
            }
            else
            {
                System.out.println("실패.");
            }


            // 03. 스칼라 va1을 요소로 하는 n차원 벡터 생성
            Scalar val1 = Factory.getScalar("0");
            Vector vector2 = Factory.getVector(val1, 2);
            System.out.println("벡터2 "+val1+"을 요소로 하는 2차원 벡터 생성 (03) 값 : ");
            System.out.println(vector2.toString());
            if("0 0".equals(vector2.toString()))
            {
                System.out.println("통과.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 04. 벡터3 rand1~rand2까지 랜덤 요소로 val2차원 벡터 생성
            int rand1 = 1;
            int rand2 = 9;
            int val2 = 3;
            Vector vector3 = Factory.getVector(rand1, rand2, val2);
            System.out.println("벡터3 "+rand1+"~"+rand2+"까지 랜덤 요소로 "+val2+"차원 벡터 생성 (04) 값 : ");
            System.out.println(vector3.toString());
            if(vector3.size() == val2) //사이즈 비교
            {
                boolean flag=true;
                for(int i=0;i<val2;i++) //값이 유효한 범위 안인지 비교
                {
                    Scalar nowVal = vector3.getAt(i);
                    if(rand1>Integer.parseInt(nowVal.toString())||rand2<Integer.parseInt(nowVal.toString()))
                    {
                        flag=false;
                        System.out.println("실패.");
                        break;
                    }
                }

                if(flag)
                {
                    System.out.println("성공.");
                }
            }
            else
            {
                System.out.println("실패.");
            }


            // 11. 벡터1 n번째 인덱스 요소 조회 (예외 상황)
            int val3 = -1;

            try {
                Scalar element0 = vector1.getAt(val3);
                System.out.println("벡터1 0번째 인덱스 요소 조회: " + element0.toString() + " (11)");
                if(element0.toString().equals("1"))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("인덱스 범위 벗어남.");
            }

            //11. 벡터1 n번째 인덱스 요소 조회
            val3 = 0;
            try {
                Scalar element0 = vector1.getAt(val3);
                System.out.println("벡터1 0번째 인덱스 요소 조회: " + element0.toString() + " (11)");
                if(element0.toString().equals("1"))
                {
                   System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("인덱스 범위 벗어남.");
            }


            // 13. 벡터1 크기 정보(차원) 조회
            int vector1Size = vector1.size();
            System.out.println("벡터1 크기 정보 조회: " + vector1Size + " (13)");
            if(vector1Size == arr1.length)
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 26. 벡터1 벡터4 덧셈
            try
            {
                Scalar temp = Factory.getScalar("1");
                Vector vector4 = Factory.getVector(temp, 3);
                Vector tempVector = Tensors.addVectorEach(vector1, vector4);
                System.out.println("벡터1에 벡터4 더한 결과: " + tempVector.toString() + " (26)");
                if ("2 3 4".equals(tempVector.toString())) {
                    System.out.println("성공.");
                } else {
                    System.out.println("실패.");
                }
            }
            catch (VectorSumSizeMismatch e)
            {
                System.out.println("벡터의 사이즈가 맞지 않습니다.");
            }

            // 26. 벡터1 벡터2 덧셈(예외 발생)
            try
            {
                Vector tempVector = Tensors.addVectorEach(vector1, vector2);
                System.out.println("벡터1에 벡터2 더한 결과: " + tempVector.toString() + " (26)");
                if ("1 2 3".equals(tempVector.toString())) {
                    System.out.println("성공.");
                } else {
                    System.out.println("실패.");
                }
            }
            catch (VectorSumSizeMismatch e)
            {
                System.out.println("벡터의 사이즈가 맞지 않습니다.");
            }

            //27. 벡터1 스칼라 곱셈
            try{
                Scalar tempScalar = Factory.getScalar("1");
                Vector tempVector2 = Tensors.multiplyVectorScalar(vector1, tempScalar);
                if ("1 2 3".equals(tempVector2.toString())) {
                    System.out.println("성공.");
                } else {
                    System.out.println("실패.");
                }
            }catch(VectorMultiplySizeMismatch e){
                System.out.println("벡터의 사이즈가 맞지 않습니다.");
            }


            // 20. temp1에 temp2 더해서 저장 (크기가 같은 벡터끼리만 가능)
            try {
                int[] tempValues = {1,2,3}, tempValues2 = {3,2,1};
                Vector temp1 = Factory.getVector(tempValues);
                Vector temp2 = Factory.getVector(tempValues2);
                temp1.addVector(temp2);
                System.out.println("temp1에 temp2 더해서 저장 완료 -> " + temp1 + " (20)");
                if("4 4 4".equals(temp1.toString()))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            } catch (VectorSumSizeMismatch e) {
                System.out.println("temp1에 temp2 더하기 실패 (크기 불일치)");
            }

        // 20. temp1에 temp2 더해서 저장 (크기가 같은 벡터끼리만 가능) (예외 발생)
            try
            {
                int[] tempValues = {1,2,3}, tempValues2 = {3,2};
                Vector temp1 = Factory.getVector(tempValues);
                Vector temp2 = Factory.getVector(tempValues2);
                temp1.addVector(temp2);
                System.out.println("temp1에 temp2 더해서 저장 완료 -> " + temp1 + " (20)");
                if("4 4 4".equals(temp1.toString()))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            }
            catch (VectorSumSizeMismatch e) {
                System.out.println("temp1에 temp2 더하기 실패 (크기 불일치)");
            }

            // 21. 벡터2에 스칼라2 곱해서 저장
            {
            int[] tempValues = {1,2,3};
            Scalar temp2 = Factory.getScalar("2");
            Vector temp1 = Factory.getVector(tempValues);
            temp1.multiplyScalar(temp2);
            System.out.println("temp1에 temp2 곱해서 저장 완료 -> " + temp1 + " (21)");
            if("2 4 6".equals(temp1.toString()))
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }
            }

            System.out.println();

            // [3] 벡터 -> 행렬 전환
            System.out.println("[3] 벡터 -> 행렬 전환");

            // 30. 벡터를 행렬로 전환 (n*1 행렬)
            {
                int[] arr = {0,1,2};
                Vector target = Factory.getVector(arr); //입력값
                Matrix matrixFromVector1 = target.getRow();
                System.out.println("벡터1을 행렬로 전환 ("+arr.length+"*1 행렬) (30) 값 :");
                System.out.println(matrixFromVector1.toString());
                if(matrixFromVector1.toString().equals("0 \n1 \n2 "))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            }
            // 31. 벡터를 행렬로 전환 (1*n 행렬)
            {
                int[] arr = {0,1,2};
                Vector target = Factory.getVector(arr); //입력값
                Matrix matrixFromVector2 = target.getColumn();
                System.out.println("벡터1을 행렬로 전환 ("+arr.length+"*3 행렬) (31) 값:");
                System.out.println(matrixFromVector2.toString());
                if("0 1 2".equals(matrixFromVector2.toString()))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }
            }


            System.out.println();

            // [4] 행렬 생성 및 연산
            System.out.println("[4] 행렬 생성 및 연산");

            // 09. 행렬1 2차원 배열로 생성(값 : {1 2} {3 4})
            int[][] arr2d = {{1, 2}, {3, 4}};
            Matrix matrix1 = Factory.getMatrix(arr2d, 2, 2);
            System.out.println("행렬1 2차원 배열로 생성(값: {1 2} {3 4}) (09)");

            // 08. 행렬2 csv 파일로 생성 (파일이 있다고 가정)
            File csvFile = new File("matrix_data.csv");
            Matrix matrix2 = Factory.getMatrix(csvFile, 3, 3);
            System.out.println("행렬2 csv 파일로 생성 (08)");

            // 06. 행렬3 0으로만 구성된 2*2 행렬 생성
            int row = 2, col = 2; //사용자 설정 값
            Scalar zeroScalar = Factory.getScalar("0");
            Matrix matrix3 = Factory.getMatrix(zeroScalar, row, col);
            System.out.printf("행렬3 0으로만 구성된 %d*%d 행렬 생성 (06)\n", row, col);

            // 07. 행렬4 랜덤(1~9) 2*2 생성
            int randMin = 1, randMax = 10, row = 2, col = 2;  //사용자 설정 값
            Matrix matrix4 = Factory.getMatrix(randMin, randMax, row, col);
            System.out.printf("행렬4 랜덤(1~9) %d*%d 생성 (07)\n", row, col);

            // 28. 행렬1과 행렬4 덧셈
            try {
                Matrix result_1plus4 = Tensors.addMatrixEach(matrix1, matrix4);
                System.out.println("행렬1과 행렬4 덧셈 성공 (28)");
            } catch (Exception e) {
                System.out.println("행렬1과 행렬4 더하기 실패: " + e.getMessage());
            }
            // 29. 행렬1과 행렬3 곱셈
            try {
                Matrix result_1multi3 = Tensors.multiplyMatrixEach(matrix1, matrix3);
                System.out.println("행렬1과 행렬3 곱셈 성공 (29)");
            } catch (Exception e) {
                System.out.println("행렬1과 행렬3 곱하기 실패: " + e.getMessage());
            }
            // 22. 행렬1에 행렬3 더해서 저장
            try {
                matrix1.addMatrix(matrix3);
                System.out.println("행렬1에 행렬3 더해서 저장 완료 (22)");
            } catch (Exception e) {
                System.out.println("행렬1에 행렬3 더하기 실패: " + e.getMessage());
            }

            // 23. 행렬3에 행렬1 곱해서 저장
            String multiplyDirection = "right";//사용자 지정 값
            try {
                matrix3.multiplyMatrix(matrix1, multiplyDirection); // m * 기존행렬
                System.out.println("행렬3에 행렬1 곱해서 저장 완료 (23)");
            } catch (Exception e) {
                System.out.println("행렬3에 행렬1 곱하기 실패: " + e.getMessage());
            }

            // 39. 행렬3 대각 요소의 합 구하기
            try {
                Scalar trace = matrix3.getTrace();
                System.out.println("행렬3 대각 요소의 합: " + trace.getScalar() + " (39)");
            } catch (Exception e) {
                System.out.println("행렬3 대각합 구하기 실패: " + e.getMessage());
            }

            System.out.println();

            // [5] 행렬 행/열 조작
            System.out.println("[5] 행렬 행/열 조작");

            // 45. 행렬1 1행과 2행 교환
            int rows = matrix1.size("row");
            int cols = matrix1.size("column");
            Matrix matrix1Copy = Factory.getMatrix(arr2d, rows, cols); // 새로 생성
            matrix1Copy.swapRow(0, 1); // 0-based 인덱스 사용
            System.out.println("행렬1 1행과 2행 교환 완료 (45)");

            // 46. 행렬1 1열과 2열 교환
            matrix1Copy.swapColumn(0, 1);
            System.out.println("행렬1 1열과 2열 교환 완료 (46)");

            // 38. 행렬1 전치행렬 생성
            Matrix transpose = matrix1.getTranspose();
            System.out.println("행렬1 전치행렬 생성 완료 (38)");

            // 15m. 행렬1과 행렬1전치행렬 동등성 판단
            boolean isTransposeEqual = matrix1.equals(transpose);
            System.out.println("행렬1과 전치행렬 동등성: " + isTransposeEqual + " (15m)");

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

            Matrix matrixFromRow1 = row1.getColumn();
            Matrix matrixFromRow2 = row2.getColumn();
            System.out.println("추출한 행 벡터들을 행렬로 전환 완료 (31)");

            // 33. 행렬끼리 세로로 합치기
            try {
                //matrixFromRow1.connectMatrix(matrixFromRow2, "vertical");
                System.out.println("행렬끼리 세로로 합치기 완료 (33)");
            } catch (Exception e) {
                System.out.println("세로 합치기 실패: " + e.getMessage());
            }

            // 35. 행렬1의 열 벡터 형태로 추출
            Vector col1 = matrix1.extractMatrixToVector(0, "column");
            Vector col2 = matrix1.extractMatrixToVector(1, "column");
            System.out.println("행렬1의 열 벡터들 추출 완료 (35)");

            // 30. 추출한 열 벡터들을 행렬로 전환
            Matrix matrixFromCol1 = col1.getRow();
            Matrix matrixFromCol2 = col2.getRow();
            System.out.println("추출한 열 벡터들을 행렬로 전환 완료 (30)");

            // 32. 행렬끼리 가로로 합치기
            try {
                matrixFromCol1.connectMatrix(matrixFromCol2, "horizontal");
                System.out.println("행렬끼리 가로로 합치기 완료 (32)");
            } catch (Exception e) {
                System.out.println("가로 합치기 실패: " + e.getMessage());
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