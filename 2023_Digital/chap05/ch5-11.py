# 파일명: ch5-11.py
# 작성자: 김승욱
# 내용: pc카메라로 영상을 읽어 윈도우의 특정 영역에서 재생하는 프로그램.

import numpy as np, cv2

# 카메라 연결
capture = cv2.VideoCapture(0)
if capture.isOpened() is None: raise Exception("카메라 연결 안됨")

main_window = np.zeros((300, 400, 3), dtype=np.uint8)

while True:
    # 카메라 영상 받기
    ret, frame = capture.read()
    if not ret: break

    # 관심 영역 표시
    rec = frame[30:30+240, 30:30+320]
    # 메인 윈도우를 검게 채운뒤 방금 만든 관심 영역을 넣음
    main_window.fill(0)
    main_window[30:30 + 240, 30:30 + 320] = rec
    # 관심 영역에 빨간색 테두리 두르기
    cv2.rectangle(main_window, (30,30), (30+320,30+240), (0,0,255), 2)

    cv2.imshow("ch5-11", main_window)
    # ESC 키를 누르면 종료
    if cv2.waitKey(1) == 27: break

capture.release()
cv2.destroyAllWindows()