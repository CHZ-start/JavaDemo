package com.chz.spring.beans;

import java.util.List;

public class HappyMachine {

    private List<String> memberList;

    private String machineName;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "HappyMachine{" +
                "memberList=" + memberList +
                '}';
    }
}
