package com.example.ResearchHub.Controllers;

import com.example.ResearchHub.Services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/contribution")
public class ContributionController {
   private ContributionService service;
}
