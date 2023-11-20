# 파일명: blur_fft.py
# 작성자: 김승욱
# 내용: 회선을 이용한 블러링 코드를
#      FFT를 이용한 주파수 영역 필터링을 이용하여 바꾼 프로그램

import numpy as np, cv2
from Common.fft2d import fft2, ifft2, calc_spectrum, fftshift

# FFT(고속 푸리에 변환) 수행 함수
def FFT(image):
    dft = np.fft.fft2(image)
    dft = fftshift(dft) # 주파수 시프트
    spectrum = calc_spectrum(dft) # 주파수 스펙트럼 영상
    return dft, spectrum

# IFFT(고속 푸리에 역변환) 수행 함수
def IFFT(dft, shape):
    dft = fftshift(dft) # 역 셔플링
    img = np.fft.ifft2(dft).real
    img = img[:shape[0], :shape[1]] # 영삽입 부분 제거
    return cv2.convertScaleAbs(img)

# 회선 수행 함수 - 주파수 도메인에서의 곱셈
def filter_fft(image, mask):
    # 영상과 마스크에 FFT 수행
    fft_image, spectrum1 = FFT(image)
    fft_mask, _ = FFT(mask)
    # 주파수 도메인에서 곱셈 수행
    result_fft = fft_image * fft_mask
    # 영상과 마스크에 IFFT 수행
    result_image = IFFT(result_fft, fft_image.shape)
    _, spectrum2 = FFT(result_image)
    return result_image, spectrum1, spectrum2

image = cv2.imread("images/filter_blur.jpg", cv2.IMREAD_GRAYSCALE)
if image is None: raise Exception("영상파일 읽기 오류")

# 블러링 마스크 원소 지정
data = [1/9, 1/9, 1/9,
         1/9, 1/9, 1/9,
         1/9, 1/9, 1/9]

# 제로 패딩을 이용하여 마스크 크기를 영상 크기로 맞춤
mask = np.zeros(image.shape, np.float32)
for i in range(3):
    for j in range(3):
        mask[i][j] = 1/9

result_image, spectrum1, spectrum2 = filter_fft(image, mask)

cv2.imshow("Original Image", image)
cv2.imshow("Result Image", result_image)
cv2.imshow("Image Spectrum", spectrum1)
cv2.imshow("Result Spectrum", spectrum2)
cv2.waitKey(0)