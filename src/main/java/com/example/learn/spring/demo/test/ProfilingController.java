package com.example.learn.spring.demo.test;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
