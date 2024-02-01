package com.example.pytorch.ai.service;

import lombok.RequiredArgsConstructor;
import org.pytorch.IValue;
import org.pytorch.Module;
import org.pytorch.Tensor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;

//https://gdngy.tistory.com/114

@Transactional
@Service
@RequiredArgsConstructor
public class PytorchService {
    @Value("${model.path}")
    private String modelPath;

    private final Module module;

    public PytorchService() {
        //모델 파일을 블러와서 모듈 생성
        module = Module.load(modelPath);
    }

    //입력 데이터를 사용하여 머신 러닝 모델을 실행하고 결과를 반환
    public float[] predict(float[] inputData) {
        Tensor input = Tensor.fromBlob(inputData, new long[]{1, inputData.length});
        Tensor output = module.forward(IValue.from(input)).toTensor();
        return output.getDataAsFloatArray();
    }

}
