package com.dogukancelik.kutuphane.controller;

import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope(value = "session")
@Component(value = "mainController")
@ELBeanName(value = "mainController")
@Join(path = "/", to = "/index.jsf")
public class MainController {
}
