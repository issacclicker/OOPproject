package test;

import java.io.DataInput;
import java.io.File;
import java.util.Objects;

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
            if(!isEqual) {
                System.out.println("스칼라1과 스칼라2 동등성 비교 성공 /결과: " + isEqual + " (15)");
            } else {
                System.out.println("스칼라1과 스칼라2 동등성 비교 실패 (15)");
            }

            // 14. 스칼라1 출력
            if("3".equals(scalar1.toString())) {
                System.out.println("스칼라1 출력 성공(14) -> " + scalar1);
            } else {
                System.out.println("스칼라1 출력 실패(14) ");
            }

            // 12. 스칼라1 지정 및 조회
            System.out.println("스칼라1 값 조회: " + scalar1.getScalar() + " (12)");
            String scalarValue = "5";
            scalar1.setScalar(scalarValue);
            if ("5".equals(scalar1.toString())){
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

            // 19. 스칼라2에 스칼라2 곱해서 저장
            scalar2.multiplyScalar(scalar2);
            if("16".equals(scalar2.toString())){
                System.out.println("스칼라2에 스칼라2 곱해서 저장 성공: " + scalar2.toString() + " (19)");
            } else {
                System.out.println("스칼라2에 스칼라2 곱해서 저장 실패 (19)");
            }

            System.out.println();

            // [2] 벡터 생성 및 연산
            System.out.println("[2] 벡터 생성 및 연산");

            // 05. 벡터1 1차원 배열(arr1)로 3차원 벡터 생성
            int[] arr1 = {1, 2, 3};
            Vector vector1 = Factory.getVector(arr1);
            System.out.println("벡터1 1차원 배열로 3차원 벡터 생성 (05) 값 : ");
            System.out.print(vector1.toString());
            if("1\n2\n3".equals(vector1.toString()))
            {
                System.out.println("통과.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 17v. 벡터1를 복사해 벡터6에 저장
            Vector vector6 = vector1.cloneSelf();
            if("1\n2\n3".equals(vector6.toString())) {
                System.out.println("벡터6에 벡터1 복제 성공 (17v) -> " + vector6.toString());
            } else {
                System.out.println("벡터6에 벡터1 복제 실패 (17v) ");
            }

            // 15v. 벡터1과 벡터6 동등성 비교
            isEqual = vector1.equals(vector6);
            if(!isEqual) {
                System.out.println("벡터1과 벡터6 동등성 비교 성공 /결과: " + isEqual + " (15v)");
            } else {
                System.out.println("벡터1과 벡터6 동등성 비교 실패 (15v)");
            }


            // 03. 스칼라 va1을 요소로 하는 n차원 벡터 생성
            Scalar val1 = Factory.getScalar("0");
            Vector vector2 = Factory.getVector(val1, 2);
            System.out.println("벡터2 "+val1+"을 요소로 하는 2차원 벡터 생성 (03) 값 : ");
            System.out.println(vector2.toString());
            if("0\n0".equals(vector2.toString()))
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


            //11. 벡터1 n번째 인덱스 요소 조회
            int val3 = 0;
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


            // 13. 벡터1 크기 정보(차원) 조회
            int vector1Size = vector1.size();
            System.out.println("벡터1 크기 정보 조회: " + vector1Size + " (13)");
            if(vector1Size == 3)
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 26. 벡터1 벡터4 더한 값 새 객체에 저장
                Scalar temp = Factory.getScalar("1");
                Vector vector4 = Factory.getVector(temp, 3);
                Vector tempVector = Tensors.addVectorEach(vector1, vector4);
                System.out.println("벡터1에 벡터4 더한 결과: " + tempVector.toString() + " (26)");
                if ("2\n3\n4".equals(tempVector.toString())) {
                    System.out.println("성공.");
                } else {
                    System.out.println("실패.");
                }

            //27. 벡터1 스칼라2 곱한 값 새 객체에 저장
            Vector tempVector2 = Tensors.multiplyVectorScalar(vector1, scalar2);
            if ("4\n8\n12".equals(tempVector2.toString())) {
                System.out.println("(27) 성공 결과 : " + tempVector2.toString());
            } else {
                System.out.println("(27) 실패");
            }

            // 20. 벡터1에 벡터4 더해서 저장
            vector1.addVector(vector4);
            System.out.println("temp1에 temp2 더해서 저장 완료 -> " + vector1 + " (20)");
            if("2\n3\n4".equals(vector1.toString()))
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 21. 벡터2에 스칼라2 곱해서 저장
            vector2.multiplyScalar(scalar2);
            if("0\n0".equals(vector2.toString()))
            {
                System.out.println("vector2에 scalar2 곱해서 저장 성공 결과 : " + vector2.toString() + " (21)");
            }
            else
            {
                System.out.println("실패.");
            }

            System.out.println();

            // [3] 벡터 -> 행렬 전환
            System.out.println("[3] 벡터 -> 행렬 전환");

            // 30. 벡터1을 n*1 행렬로 전환 후 새 객체에 저장
                Matrix matrixFromVector1 = vector1.getColumn();
                System.out.println("벡터1을 행렬로 전환 (3*1 행렬) (30) 값 :");
                System.out.println(matrixFromVector1.toString());
                if(matrixFromVector1.toString().equals("2 \n3 \n4 "))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

            // 31. 벡터1을 1*n 행렬로 전환 후 새 객체에 저장
                Matrix matrixFromVector2 = vector1.getRow();
                System.out.println("벡터1을 행렬로 전환 (1*3행렬) (31) 값:");
                System.out.println(matrixFromVector2.toString());
                if("2 3 4 ".equals(matrixFromVector2.toString()))
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

            System.out.println();

            // [4] 행렬 생성 및 연산
            System.out.println("[4] 행렬 생성 및 연산");

            // 09. 행렬1 2차원 배열로 생성(값 : {1 2} {3 4})
            int[][] matrix1_array = {{1, 2}, {3, 4}}; // 사용자 지정 값
            int row = 2, col = 2 ; //사용자 지정 값
            Matrix matrix1 = Factory.getMatrix(matrix1_array, row , col);
            if(("1 3 \n2 4 ".equals(matrix1.toString()))){
                System.out.println("행렬1 2차원 배열로 생성 성공 :" +  matrix1 + "(09)");
            } else {
                System.out.println("행렬1 2차원 배열로 생성 실패 (09)");
            }

            // 14m. 행렬1 출력
            if(("1 3 \n2 4 ".equals(matrix1.toString()))){
                System.out.println("행렬1 출력 성공");
            } else {
                System.out.println("행렬1 출력 실패");
            }

            // 17m. 행렬1을 복사해 행렬6에 저장
            Matrix matrix6 = matrix1.cloneSelf();
            if("1 3 \n2 4 ".equals(vector6.toString())) {
                System.out.println("행렬6에 행렬1 복제 성공 (17m) -> " + matrix6.toString());
            } else {
                System.out.println("행렬6에 행렬1 복제 실패 (17m) ");
            }

            // 08. 행렬2 csv 파일로 생성 (파일이 있다고 가정)
            File csvFile = new File("matrix_data.csv");
            Matrix matrix2 = Factory.getMatrix(csvFile, 3, 3);
            if(("0 2 1 \n1 0 3 \n4 5 6 ".equals(matrix2.toString()))){
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
                System.out.printf("행렬3 %s으로만 구성된 %d*%d 행렬 생성 성공 :" +  matrix3 + "(06)\n" ,matrix3_value, row, col);
            } else {
                System.out.printf("행렬3 %s으로만 구성된 %d*%d 행렬 생성 실패 (06)\n",matrix3_value, row, col);
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

            // 29. 행렬1과 행렬3 곱셈

                Matrix result_1multi3 = Tensors.multiplyMatrixEach(matrix1, matrix3);
                if(("0 0 \n0 0 ".equals(result_1multi3.toString()))){
                    System.out.println("행렬1과 행렬3 곱셈 성공 : "+  result_1multi3 +"(29)");
                } else {
                    System.out.println("행렬1과 행렬3 곱셈 실패 (29)");
                }


            // 22. 행렬1에 행렬3 더해서 저장

                matrix1.addMatrix(matrix3);
                if(("1 3 \n2 4 ".equals(matrix1.toString()))){
                    System.out.println("행렬1에 행렬3 더해서 저장 성공 : "+  matrix1 +"(22)");
                } else {
                    System.out.println("행렬1과 행렬3 더해서 저장 실패 (22)");
                }

            // 23. 행렬3에 행렬1 곱해서 저장
            String multiplyDirection = "right";//사용자 지정 값

                matrix3.multiplyMatrix(matrix1, multiplyDirection); //m * 기존행렬
                if(("0 0 \n0 0 ".equals(matrix3.toString()))){
                    System.out.println("행렬3에 행렬1 곱해서 저장 성공 : "+  matrix3 +"(23)");
                } else {
                    System.out.println("행렬3에 행렬1 곱해서 저장 실패 (23)");
                }


            // 39. 행렬3 대각 요소의 합 구하기

                Scalar trace = matrix3.getTrace();
                if("0".equals(trace.toString())) {
                    System.out.println("행렬3 대각 요소의 합 구하기 성공: " + trace.getScalar() + " (39)");
                } else {
                    System.out.println("행렬3 대각 요소의 합 구하기 실패 (39)");
                }


            System.out.println();

            // [5] 행렬 행/열 조작
            System.out.println("[5] 행렬 행/열 조작");

            // 45. 행렬1 1행과 2행 교환
            matrix1.swapRow(0, 1); // 0-based 인덱스 사용
            if("2 4 \n1 3 ".equals(matrix1.toString())) {
                System.out.println("행렬1 1행과 2행 교환 성공 (45)");
            } else {
                System.out.println("행렬1 1행과 2행 교환 실패(45)");
            }

            // 46. 행렬1 1열과 2열 교환
            matrix1.swapColumn(0, 1);
            if("4 2 \n3 1 ".equals(matrix1.toString())) {
                System.out.println("행렬1 1열과 2열 교환 성공 (46)");
            } else {
                System.out.println("행렬1 1열과 2열 교환 실패 (46)");
            }
            // 38. 행렬1 전치행렬 생성
            Matrix transpose = matrix1.getTranspose();
            if("4 3 \n2 1 ".equals(transpose.toString())) {
                System.out.println("행렬1 전치행렬 생성 완료"+transpose+"(38)");
            }else {
                System.out.println("행렬1 전치행렬 생성 실패 (38)");
            }
            // 15m. 행렬1과 행렬1전치행렬 동등성 판단
            boolean isTransposeEqual = matrix1.equals(transpose);
            if(!isTransposeEqual) {
                System.out.println("행렬1과 전치행렬 동등성 판단 성공: " + isTransposeEqual + " (15m)");
            } else {
                System.out.println("행렬1과 전치행렬 동등성 판단 실패 (15m)");
            }

            System.out.println();

            // [6] 행렬 구조 추출 및 결합
            System.out.println("[6] 행렬 구조 추출 및 결합");

            // 36. 행렬1의 1행~1행, 1열~2열 을 부분 행렬로 추출
            Matrix SubMatrix = matrix1.extractSubMatrix(1, 1, 1, 2);
            if("4 3 ".equals(SubMatrix.toString()))
            {
                System.out.println("행렬1의 1행~1행, 1열~2열 을 부분 행렬로 추출 결과 :" + SubMatrix.toString());
                System.out.println("(36) 통과");
            } else {
                System.out.println("(36) 실패");
            }

            // 37. 행렬1의 1행, 1열을 제외한 부분 행렬 추출
            Matrix SubMatrix2 = matrix1.extractSubMatrix(1, 1);
            if("1 ".equals(SubMatrix2.toString()))
            {
                System.out.println("행렬1의 1행, 1열을 제외한 부분 행렬 추출 결과 :" + SubMatrix2.toString());
                System.out.println("(37) 통과");
            } else {
                System.out.println("(37) 실패");
            }

            // 34. 행렬1의 1행 벡터 형태로 추출
            Vector row1 = matrix1.extractMatrixToVector(1, "row");
            System.out.println("행렬1의 1행 벡터 형태로 추출 완료 (34)");
            if("4\n3".equals(row1.toString()))
            {
                System.out.println("(34-1) 통과");
            }
            else
            {
                System.out.println(("(34-1) 실패"));
            }

            // 34. 행렬1의 2행 벡터 형태로 추출
            Vector row2 = matrix1.extractMatrixToVector(2, "row");
            System.out.println("행렬1의 2행 벡터 형태로 추출 완료 (34)");
            if("2\n1".equals(row2.toString()))
            {
                System.out.println("(34-2) 통과");
            }
            else
            {
                System.out.println(("(34-2) 실패"));
            }

            // 31. 추출한 행 벡터들을 행렬로 전환

            Matrix matrixFromRow1 = row1.getColumn();
            Matrix matrixFromRow2 = row2.getColumn();
            if("4 3 ".equals(matrixFromRow1.toString()) && "2 1 ".equals(matrixFromRow2.toString()))
            {
                System.out.println("(31) 통과");
            }
            else
            {
                System.out.println("(31) 실패");
            }

            // 33. 행렬끼리 세로로 합치기
            matrixFromRow1.connectMatrix(matrixFromRow2, "vertical");
            if("4 3 \n2 1 ".equals(matrixFromRow1.toString()))
            {
                System.out.println("(33) 통과");
            }
            else
            {
                System.out.println("(33) 실패");
            }

            // 35. 행렬1의 열 벡터 형태로 추출
            Vector col1 = matrix1.extractMatrixToVector(1, "column");
            Vector col2 = matrix1.extractMatrixToVector(2, "column");
            if("4\n2".equals(col1.toString()) && "3\n1".equals(col2.toString()))
            {
                System.out.println("(35) 통과");
            } else {
                System.out.println("(35) 실패");
            }

            // 30. 추출한 열 벡터들을 행렬로 전환
            Matrix matrixFromCol1 = col1.getRow();
            Matrix matrixFromCol2 = col2.getRow();
            if("4 \n2 ".equals(matrixFromCol1.toString()) && "3 \n1 ".equals(matrixFromCol2.toString()))
            {
                System.out.println("(30) 통과");
            }
            else
            {
                System.out.println("(30) 실패");
            }

            // 32. 행렬끼리 가로로 합치기
            matrixFromCol1.connectMatrix(matrixFromCol2, "horizontal");
            if("4 3 \n2 1 ".equals(matrixFromCol1.toString()))
            {
                System.out.println("(32) 통과");
            }
            else {
                System.out.println("(32) 실패");
            }

            System.out.println();

            // [7] RREF와 역행렬 구하기
            System.out.println("[7] RREF와 역행렬 구하기");

            // 51. 행렬2 RREF 구하기
            Matrix rrefResult = matrix2.getRREF();
            if("1 0 0 \n0 1 0 \n0 0 1 ".equals(rrefResult.toString()))
            {
                System.out.println("(51) 성공");
            } else {
                System.out.println("(51) 실패");
            }

            // 14m. 행렬2 2차원 배열 모양으로 콘솔 출력


            // 13m. 행렬2 크기 정보 조회
            int rows = matrix2.size("row");
            int cols = matrix2.size("column");
            if(rows == 3 && cols == 3)
            {
                System.out.println("행렬2 크기: " + rows + "x" + cols + " (13m)");
                System.out.println("통과 (13m)");
            }

            // 10. 단위행렬 생성
            Matrix identityMatrix = Factory.getMatrix(rows); // (입력값: 바로위에서 알게된 3)
            if("1 0 0 \n0 1 0 \n0 0 1 ".equals(identityMatrix.toString()))
            {
                System.out.println("단위행렬 생성 완료 (10)");
                System.out.println("(10) 성공");
            }

            // 47. n번째 행에 상수 k배
            matrix2.multiplyByScalar(0, Factory.getScalar("2"), "row");
            if("0 4 2 \n1 0 3 \n4 5 6 ".equals(matrix2.toString()))
            {
                System.out.println("47. n번째 행에 상수 k배 성공 결과 : " + matrix2.toString());
            }
            else
            {
                System.out.println("47. n번째 행에 상수 k배 실패");
            }

            // 48. n번째 열에 상수 k배
            matrix2.multiplyByScalar(0, Factory.getScalar("2"), "column");
            if("0 4 2 \n2 0 3 \n8 5 6 ".equals(matrix2.toString()))
            {
                System.out.println("48. n번째 열에 상수 k배 성공 결과 : " + matrix2.toString());
            }
            else
            {
                System.out.println("48. n번째 열에 상수 k배 실패");
            }

            // 49. m번째 행에 n번째 행 상수 k배 더하기
            matrix2.addMultipliedRow(0, 1, Factory.getScalar("2"));
            if("4 4 8 \n2 0 3 \n8 5 6 ".equals(matrix2.toString()))
            {
                System.out.println("49. m번째 행에 n번째 행 상수 k배 더하기 성공 결과 : " + matrix2.toString());
            }
            else
            {
                System.out.println("49. m번째 행에 n번째 행 상수 k배 더하기 실패");
            }

            // 50. m번째 열에 n번째 열 상수 k배 더하기
            matrix2.addMultipliedColumn(0, 1, Factory.getScalar("2"));
            if("12 4 8 \n2 0 3 \n16 5 6 ".equals(matrix2.toString()))
            {
                System.out.println("49. m번째 행에 n번째 행 상수 k배 더하기 성공 결과 : " + matrix2.toString());
            }
            else
            {
                System.out.println("49. m번째 행에 n번째 행 상수 k배 더하기 실패");
            }

            // 52. RREF 판단
            boolean isRREF = matrix2.isRREF();
            System.out.println("행렬2 " + (isRREF ? "is RREF" : "is not RREF") + " (52)");
            if(isRREF)
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            // 54. 역행렬 구하기
            Matrix inverse = matrix2.getReversed();
            if("-0.34 0.36 0.27 \n0.82 -1.27 -0.45 \n0.23 0.09 -0.18 ".equals(inverse.toString()))
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            System.out.println();

            // [8] RREF로 구한 값의 특징 판단
            System.out.println("[8] RREF 특징 판단");

                // 40. 정사각 행렬인지
                boolean isSquare = rrefResult.isSquareMatrix();
                System.out.println("RREF가 정사각 행렬인지: " + isSquare + " (40)");
                if(isSquare)
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

                // 41. 상삼각 행렬인지
                boolean isUpper = rrefResult.isUpperTriangularMatrix();
                System.out.println("RREF가 상삼각 행렬인지: " + isUpper + " (41)");
                if(isSquare)
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

                // 42. 하삼각 행렬인지
                boolean isLower = rrefResult.isLowerTriangularMatrix();
                System.out.println("RREF가 하삼각 행렬인지: " + isLower + " (42)");
                if(isLower)
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

                // 43. 단위 행렬인지
                boolean isIdentity = rrefResult.isIdentityMatrix();
                System.out.println("RREF가 단위 행렬인지: " + isIdentity + " (43)");
                if(isIdentity)
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }

                // 44. 영 행렬인지
                boolean isZero = rrefResult.isZeroMatrix();
                System.out.println("RREF가 영 행렬인지: " + isZero + " (44)");
                if(isZero)
                {
                    System.out.println("성공.");
                }
                else
                {
                    System.out.println("실패.");
                }


            System.out.println();

            // [9] 행렬식 구하기
            System.out.println("[9] 행렬식 구하기");

            // 53. 행렬식 구하기
            // 14m. 행렬 크기 정보 조회
            Scalar temp5 = Factory.getScalar("1");
            Matrix matrix5 = Factory.getMatrix(temp5,2,2);
            int matrix5Rows = matrix5.size("row");
            int matrix5Cols = matrix5.size("column");
            System.out.println("행렬 크기: " + matrix5Rows + "x" + matrix5Cols + " (14m)");
            Scalar determinantValue = matrix5.getDeterminant();
            if("0".equals(determinantValue.toString()))
            {
                System.out.println("성공.");
            }
            else
            {
                System.out.println("실패.");
            }

            System.out.println();

            // 예외처리 테스트
            System.out.println("[예외처리 테스트]");

            //20 크기가 같지 않은 두 벡터 덧셈 시도
            try {
                vector1.addVector(vector2); // 3차원 + 2차원
                System.out.println("벡터 덧셈 성공 (예상외)");
            } catch (VectorSumSizeMismatch e) {
                System.out.println("VectorSumSizeMismatch");
            }

            //26 크기가 같지 않은 두 벡터 덧셈 시도
            try {
               Tensors.addVectorEach(vector1,vector2); // 3차원 + 2차원
                  System.out.println("벡터 덧셈 성공 (예상외)");
            } catch (VectorSumSizeMismatch e) {
                System.out.println("VectorSumSizeMismatch");
            }

            //22 크기가 같지 않은 두 행렬 덧셈 시도
            try
            {
                matrix1.addMatrix(matrix2);
                System.out.println("행렬 덧셈 성공 (예상외)");
            }
            catch(MatrixSumSizeMismatch e)
            {
                System.out.println("MatrixSumSizeMismatch");
            }

        //28 크기가 같지 않은 두 행렬 덧셈 시도
        try
        {
            Tensors.addMatrixEach(matrix1,matrix2);
            System.out.println("행렬 덧셈 성공 (예상외)");
        }
        catch(MatrixSumSizeMismatch e)
        {
            System.out.println("MatrixSumSizeMismatch");
        }


            //23 크기가 맞지 않는 행렬 곱셈 시도
            try {
                matrix1.multiplyMatrix(matrix2, "left"); // 2x2 * 3x3
                System.out.println("행렬 곱셈 성공 (예상외)");
            } catch (MatrixMultiplySizeMismatch e) {
                System.out.println("MatrixMultiplySizeMismatch");
            }

        //29 크기가 맞지 않는 행렬 곱셈 시도
        try {
            Tensors.multiplyMatrixEach(matrix1,matrix2); // 2x2 * 3x3
            System.out.println("행렬 곱셈 성공 (예상외)");
        } catch (MatrixMultiplySizeMismatch e) {
            System.out.println("MatrixMultiplySizeMismatch");
        }

            //32 행수가 다른 두 행렬을 가로로 합치기 시도
            try {
                matrix1.connectMatrix(matrix2, "horizontal"); // 2x2와 3x3
                System.out.println("가로 합치기 성공 (예상외)");
            } catch (MatrixColumnSizeMismatch e) {
                System.out.println("MatrixColumnSizeMismatch");
            }

            //33 열수가 다른 두 행렬을 세로로 합치기 시도
            try
            {
                matrix1.connectMatrix(matrix2, "vertical");
            }
            catch (MatrixColumnSizeMismatch e)
            {
                System.out.println("MatrixColumnSizeMismatch");
            }

        //3 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getVector(Factory.getScalar("0"),-1);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //4 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getVector(1,9,0);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

            //5 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
            try
            {
                Factory.getVector(null);
                System.out.println("생성 성공 (예상외)");
            }
            catch(DimensionCannotBeZero e)
            {
                System.out.println("DimensionCannotBeZero");
            }

        //6 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getMatrix(Factory.getScalar("0"),-1,-1);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //7 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getMatrix(1,9,-1,-1);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //8 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getMatrix(csvFile,-1,-1);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //9 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            int[][] arr={{0}};
            Factory.getMatrix(arr,-1,-1);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //10 벡터, 행렬의 생성에서 차원을 0이하로 설정 후 시도
        try
        {
            Factory.getMatrix(0);
            System.out.println("생성 성공 (예상외)");
        }
        catch(DimensionCannotBeZero e)
        {
            System.out.println("DimensionCannotBeZero");
        }

        //11v 유효하지 않은 인덱스의 조회, 접근
        try
        {
            vector1.setAt(Factory.getScalar("0"),-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //11v 유효하지 않은 인덱스의 조회, 접근
        try
        {
            vector1.getAt(-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //11m 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.setMatrixAt(-1,-1,Factory.getScalar("0"));
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //11m 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.getMatrixAt(-1,-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //34 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.extractMatrixToVector(-1,"h");
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //35 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.extractMatrixToVector(-1,"z");
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //36 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.extractSubMatrix(-1,-1,-1,-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //37 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.extractSubMatrix(-1,-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //45 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.swapRow(-1,-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //46 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.swapColumn(-1,-1);
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //49 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.addMultipliedRow(-1,-1,Factory.getScalar("0"));
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //50 유효하지 않은 인덱스의 조회, 접근
        try
        {
            matrix1.addMultipliedColumn(-1,-1,Factory.getScalar("0"));
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //53 행렬식을 얻을 수 없는 행렬에서의 행렬식 얻기 시도
        try
        {
            Matrix matrix10 = Factory.getMatrix(Factory.getScalar("0"),3,4);
            matrix10.getDeterminant();
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }

        //54 비가역행렬에서의 역행렬 얻기 시도
        try
        {
            Matrix matrix10 = Factory.getMatrix(Factory.getScalar("1"),2,2);
            matrix10.getReversed();
            System.out.println("접근 성공 (예상외)");
        }
        catch (IndexOutOfBounds e)
        {
            System.out.println("IndexOutOfBounds");
        }


        System.out.println("\n=== 모든 테스트 완료 ===");

        }
}