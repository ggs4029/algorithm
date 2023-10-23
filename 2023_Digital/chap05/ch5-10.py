# 파일명: ch5-10.py
# 작성자: 김승욱
# 내용: pc카메라로 영상을 읽어 특정 부분의 합과 평균을 구하는 프로그램

import numpy as np, cv2

# 카메라 연결
capture = cv2.VideoCapture(0)
if capture.isOpened() is None: raise Exception("카메라 연결 안됨")

while True:
    # 카메라 영상 받기
    ret, frame = capture.read()
    if not ret: break

    # 관심 영역 설정
    x, y = 200, 100
    w, h = 200, 100
    rec = frame[y:y + h, x:x + w]

    # 합과 평균 계산
    sum_value = cv2.sumElems(rec)
    # 원소 순회 방법
    blue, green, red = 0, 0, 0
    for x in range(h):
        for y in range(w):
            pixel = rec[x,y]
            blue += pixel[0]
            green += pixel[1]
            red += pixel[2]
    # cv2.mean() 함수 사용 방법
    mean_value2 = cv2.mean(rec)

    print("관심 영역의 합: ", sum_value)
    print("평균 원소 순회 방법 사용: (", blue/(w*h),green/(w*h),red/(w*h),")")
    print("평균 cv2.mean() 사용: ", mean_value2)
    cv2.imshow("ch5-10", frame)

    # ESC 키를 누르면 종료
    if cv2.waitKey(1) == 27: break

capture.release()
cv2.destroyAllWindows()