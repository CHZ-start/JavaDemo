package com.chz.spring.beans;

import java.util.List;

public class HappyTeam {

    private String teamName;
    private Integer memberCount;
    private Double memberSalary;

    private List<String> memberList;

    public HappyTeam(String teamName, Integer memberCount, Double memberSalary) {
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "HappyTeam{" +
                "teamName='" + teamName + '\'' +
                ", memberCount=" + memberCount +
                ", memberSalary=" + memberSalary +
                ", memberList=" + memberList +
                '}';
    }
}
