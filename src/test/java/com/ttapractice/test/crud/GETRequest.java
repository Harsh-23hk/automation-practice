package com.ttapractice.test.crud;

import com.ttapractice.base.BaseAction;
import com.ttapractice.endpoints.APIConstant;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GETRequest extends BaseAction {


    @Test
    public void getAllRecord(){
        requestSpecification.basePath(APIConstant.CREATE_GET_POST_URL_BOOKING);
        response = RestAssured.given().spec(requestSpecification).when().get();
        validatableResponse=response.then().log().all();

        validatableResponse.statusCode(200);
    }


    @Test
    public void getRecordById(ITestContext iTestContext){
        requestSpecification.basePath(APIConstant.CREATE_GET_POST_URL_BOOKING+"/"+iTestContext.getAttribute("bookingid"));
        response = RestAssured.given().spec(requestSpecification).when().get();
        validatableResponse=response.then().log().all();

        validatableResponse.statusCode(200);
    }
}



