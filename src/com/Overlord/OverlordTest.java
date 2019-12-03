package com.Overlord;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class OverlordTest {
  @Test
  void InstantiateOverlordTest() {
    System.out.println("Testing: instantiating overlord");

    Overlord overlord = new Overlord();
  }

  @ParameterizedTest(name = "{3}")
  @CsvFileSource(resources = "tests/loginTests.csv")
  void login(int type, String id, int expected, String desc) {
    Overlord overlord = new Overlord();
    System.out.println("Testing: " + desc);
    System.out.println("type: " + type + "\nid: " + id);
    assertEquals(expected, overlord.login(type, id), desc);
  }

  @Test
  void logout() {
    Overlord overlord = new Overlord();
    System.out.println("Testing: logging out");


    overlord.login(0, "012345678");
    assertEquals(1,overlord.logout(), "log out returns 1");
  }

  @ParameterizedTest(name = "{2}")
  @CsvFileSource(resources = "tests/memberCheckInTests.csv")
  void memberCheckIn(String id, int expected, String message) {
    Overlord overlord = new Overlord();
    System.out.println("Testing: " + message + " with no provider login");

    assertEquals(-2, overlord.memberCheckIn(id), message + " with no provider login");

    System.out.println("Testing: " + message + " with provider login");
    overlord.login(0, "012345678");

    assertEquals(expected, overlord.memberCheckIn(id), message);
  }

  @Test
  void viewMember() {
    Overlord overlord = new Overlord();

    assertEquals(-1, overlord.viewMember(), "no member checked in");

    overlord.login(0, "012345678");
    overlord.memberCheckIn("012345678");

    assertEquals(1, overlord.viewMember(), "member checked in displays");
  }


  @Test
  void memberCheckOut() {
    Overlord overlord = new Overlord();

    assertEquals(-1, overlord.memberCheckOut(), "no member checked in");

    overlord.login(0, "012345678");
    overlord.memberCheckIn("012345678");

    assertEquals(1, overlord.memberCheckOut(), "member checked in checks out");
  }

  @Test
  void addMember() {
    Overlord overlord = new Overlord();

  }

  @Test
  void removeMember() {
    Overlord overlord = new Overlord();
  }

  @Test
  void suspendMember() {
    Overlord overlord = new Overlord();
  }

  @Test
  void renewMember() {
    Overlord overlord = new Overlord();
  }

  @Test
  void searchMember() {
    Overlord overlord = new Overlord();
  }

  @Test
  void addProvider() {
    Overlord overlord = new Overlord();
    String[] testArray = new String[7];
    Arrays.fill(testArray, "");

    assertEquals(-1, overlord.addProvider(testArray), "add member fails on null");
    assertEquals(1, overlord.addProvider(testArray), "add member fails on null");
  }

  @Test
  void removeProvider() {
    Overlord overlord = new Overlord();
  }

  @Test
  void searchProvider() {
    Overlord overlord = new Overlord();
  }

  @Test
  void displayCurrentServices() {
    Overlord overlord = new Overlord();
  }

  @Test
  void addService() {
    Overlord overlord = new Overlord();
  }

  @Test
  void removeService() {
    Overlord overlord = new Overlord();
  }

  @Test
  void searchService() {
    Overlord overlord = new Overlord();
  }

  @Test
  void genMemberReport() {
    Overlord overlord = new Overlord();
  }

  @Test
  void genProviderReport() {
    Overlord overlord = new Overlord();
  }

  @Test
  void genAllMemberReports() {
    Overlord overlord = new Overlord();
  }

  @Test
  void genAllProvidersReports() {
    Overlord overlord = new Overlord();
  }

  @Test
  void sendReports() {
    Overlord overlord = new Overlord();
  }

  @Test
  void generateServiceRecord() {
    Overlord overlord = new Overlord();
  }

  @Test
  void requestDirectory() {
    Overlord overlord = new Overlord();
  }

  @Test
  void generateBill() {
    Overlord overlord = new Overlord();
  }

}

