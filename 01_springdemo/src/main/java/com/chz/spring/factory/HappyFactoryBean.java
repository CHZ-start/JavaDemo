package com.chz.spring.factory;

import com.chz.spring.beans.HappyMachine;
import org.springframework.beans.factory.FactoryBean;

public class HappyFactoryBean implements FactoryBean<HappyMachine> {

    private String machineName;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    @Override
    public HappyMachine getObject() throws Exception {
        HappyMachine happyMachine = new HappyMachine();
        happyMachine.setMachineName(this.machineName);
        return happyMachine;
    }

    @Override
    public Class<?> getObjectType() {
        return HappyMachine.class;
    }
}
