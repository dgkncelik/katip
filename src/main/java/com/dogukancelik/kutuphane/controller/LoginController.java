package com.dogukancelik.kutuphane.controller;

import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope(value = "session")
@Component(value = "loginControlller")
@ELBeanName(value = "loginController")
@Join(path = "/login", to = "/login.jsf")
public class LoginController {
}
