# 파일명: ch4-13.py
# 작성자: 김승욱
# 내용: 컬러 영상 파일을 적재하여
#       test.jpg 와 test.png파일로 각각 저장하는 프로그램
#       이때 영상 파일은 가장 좋은 화질로 압축

import cv2

# 교재의 학습자료 파일을 그대로 활용하였습니다
image = cv2.imread("images/read_color.jpg", cv2.IMREAD_COLOR)
if image is None: raise Exception("영상 파일 읽기 에러")

# jpg -> 100이 제일 좋은 화질
params_jpg = (cv2.IMWRITE_JPEG_QUALITY, 100)  # JPG 화질 설정
# png -> 0이 제일 좋은 화질
params_png = [cv2.IMWRITE_PNG_COMPRESSION, 0]  # PNG 압축 레벨 설정

## 행렬을 영상 파일로 저장
cv2.imwrite("images/write_test2.jpg", image, params_jpg)  # 지정 화질로 저장
cv2.imwrite("images/write_test3.png", image, params_png)
print("저장 완료")