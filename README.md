# OOPproject

[객지프과제일정](https://www.notion.so/1e6ff87161e780ef82e1e34f22d64e4f?pvs=21)

# 전체 개요(TodoList)

[project_req.pdf](attachment:1c46ea61-4540-4322-b07c-98c6538322c4:project_req.pdf)

- 패키지 구성
    1. 스칼라, 벡터, 행렬의 기본 기능은 스칼라에서 구현 후 상속
    2. 생성 기능은 [Scalar.java](http://Scalar.java) [Vector.java](http://Vector.java) [Matrix.java](http://Matrix.java) 에서 각각의 생성자를 구성하는 방식으로 구현한다. 
    
    <aside>
    🛠
    
    src
    
    - tensor
        - Scalar.java (public interface)
        - Vector.java (public interface)
        - Matrix.java (public interface)
        - ScalarImpl.java ( class ScalarImpl implements Scalar) 디폴트
        - VectorImpl.java ( class VectorImpl implements Vector) 디폴트
        - MatrixImpl.java ( class MatrixImpl implements Matrix) 디폴트
        - Factory.java (public class)
        - Tensors.java (public class)
        - XXXException.java (public class) ( ) 여러개
    - test
        - Test.java
    </aside>
    

## 1. 기본기능

### 1-1. 스칼라의 기본 기능

- [ ]  1-1-1. 스칼라 생성
    - [ ]  a) 입력해서 생성
    - [ ]  b) i~j 사이의 무작위 생성
- [ ]  1-1-2. 스칼라 값 입력 및 조회 (String으로 입출력)
- [ ]  1-1-3. 값의 대소 비교(only 스칼라) (True or False)
- [ ]  1-1-4. 객체 복제

### 1-2.벡터의 기본기능

- [ ]  1-2-1. 벡터 생성
    - [ ]  a) 값 하나 입력 후 모든 요소의 값을 해당 값으로 하는 n차원
    - [ ]  b) i ~ j 무작위 값 m*n 행렬 생성
    - [ ]  c) csv파일 입력 받고 m*n 생성
    - [ ]  d) 2차원 배열 입력 받고 m*n 생성
- [ ]  1-2-2. 특정 위치 요소 지정 및 조회  (특정위치 입력받기 & 리턴)
- [ ]  1-2-3. 크기 정보 조회 (차원)
- [ ]  1-2-4. 객체 콘솔에 출력 (1차원 배열로)
- [ ]  1-2-5. 객체 동등성 판단 (True or False)
- [ ]  1-2-6. 객체 복제 (deep copy)

### 1-3.행렬의 기본기능

- [ ]  1-3-1. 행렬 생성
    - [ ]  a) 값 하나 입력&모든 요소를 그 값으로 하는 m*n행렬 생성
    - [ ]  b) i ~ j 무작위 값 m*n 행렬 생성
    - [ ]  c) csv파일 입력 받고 m*n 생성
    - [ ]  d) 2차원 배열 입력 받고 m*n 생성
    - [ ]  e) 단위 행렬 생성
- [ ]  1-3-2. 특정 위치 요소 지정 및 조회 (특정위치 입력, 지정->스칼라로 입력/조회->스칼라로 리턴)
- [ ]  1-3-3. 크기 정보 조회 (행개수 및 열개수)
- [ ]  1-3-4. 객체 콘솔에 출력 (2차원 배열 모양으로)
- [ ]  1-3-5. 객체 동등성 판단 (True or False)
- [ ]  1-3-6. 객체 복제

## 2. 연산기능

### 스칼라의 연산

- non-static
    - [ ]  다른 스칼라와 덧셈
    - [ ]  다른 스칼라와 곱셈
- 디폴트 static
    - [ ]  전달 받은 두 스칼라의 덧셈
    - [ ]  전달 받은 두 스칼라의 곱셈

### 벡터의 연산

- non-static
    - [ ]  다른 벡터와의 덧셈
    - [ ]  다른 스칼라와의 곱셈
- 디폴트 static
    - [ ]  전달 받은 두 벡터의 덧셈
    - [ ]  전달받은 스칼라와 벡터의 곱셈

### 행렬의 연산

- non-static
    - [ ]  다른 행렬과 덧셈
    - [ ]  다른 행렬과의 곱셈 / 왼쪽, 오른쪽 곱해지는 경우 모두 지원
- 디폴트 static
    - [ ]  전달 받은 두 행렬ㄹ의 덧셈
    - [ ]  전달 받은 두 행렬의 곱셈

## 3. 고급기능

### 벡터의 고급기능

- [ ]  n차원 벡터는 자신으로 n*1 행렬을 반환할 수 있다
- [ ]  n차원 벡터는 자신으로 1*n 행렬을 반환할 수 있다
- 행렬*벡터 연산을 → 행렬*행렬 으로 수행하기 위해

### 행렬의 고급기능

- 디폴트 static ( 두 행렬을 전달받아 쓰는 방식)
- [ ]  행렬은 다른 행렬과 가로로 합쳐질 수 있다.
- [ ]  행렬은 다른 행렬과 세로로 합쳐질 수 있다.

- [ ]  특정 행 벡터 추출
- [ ]  특정 열 벡터 추출
- [ ]  특정 범위의 부분 행렬 추출
    1. 시작과 끝 행 인덱스, 시작과 끝 열 인덱스를 사용하여 범위 지정
    2. 특정 행 및 열을 지정한 거 제외한 전체 행렬 추출
- [ ]  전치 행렬 추출 (인덱스 바꾸기)
- [ ]  주대각선 값 다 더하기
- 판별
- [ ]  정사각
- [ ]  상삼각
- [ ]  하삼각
- [ ]  단위 행렬
- [ ]  영행렬
- [ ]  기약행 사다리꼴

- 교환
- [ ]  특정 두 행 위치 교환
- [ ]  특정 두 열 위치 교환

- 상수배
- [ ]  특정 행에 상수배
- [ ]  특정 열에 상수배

- [ ]  자신으로 부터 기약행 사다리꼴 추출
- [ ]  자신의 행렬식 추출
- [ ]  자신의 역행렬 구하기

# ⏯️순서도

![제목 없는 다이어그램.drawio.png](attachment:a650c64c-4539-4b7c-b126-8736b68054f5:제목_없는_다이어그램.drawio.png)

aaaaa
