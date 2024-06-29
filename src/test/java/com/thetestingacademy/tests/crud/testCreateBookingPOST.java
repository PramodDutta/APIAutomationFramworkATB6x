package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class testCreateBookingPOST extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Promode")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking() {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // DeSer
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Pramod");

        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);
    }


    @Test(groups = "smoke")
    @Owner("Promode")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingNegative() {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createInvalidPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(500);

    }


}
