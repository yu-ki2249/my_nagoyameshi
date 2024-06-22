package com.example.nagoyameshi.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {  
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
   
        
    public AdminHomeController(UserRepository userRepository, RestaurantRepository restaurantRepository)
    {
        this.userRepository = userRepository; 
        this.restaurantRepository = restaurantRepository; 
     
    }    
    
    @GetMapping
    public String index(Model model) {   
        long totalMembers= userRepository.countByRoleNameInRoleFreeMemberOrRolePaidMember();
        long totalFreeMembers = userRepository.countByRole_Name("ROLE_FREE_MEMBER");
        long totalPaidMembers = userRepository.countByRole_Name("ROLE_PAID_MEMBER");;
        long totalRestaurants = restaurantRepository.count();
      
        
     
        
         
        
        model.addAttribute("totalMembers", totalMembers);
        model.addAttribute("totalFreeMembers", totalFreeMembers);
        model.addAttribute("totalPaidMembers", totalPaidMembers);
        model.addAttribute("totalRestaurants", totalRestaurants);
       
       
        
        return "admin/index";
    }
}