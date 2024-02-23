package com.resturantDemo.controller;

import com.resturantDemo.appconstant.AppConstants;
import com.resturantDemo.dto.ResturantDto;
import com.resturantDemo.entity.Resturant;
import com.resturantDemo.service.ResturantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = AppConstants.RESTURANT_CONTROLLER)
@RestController
public class ResturantController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResturantController.class);

    @Autowired
    private ResturantService resturantService;

    @PostMapping(value = AppConstants.SAVE)
    public void saveResturantDetails(@RequestBody Resturant resturant) {
        LOGGER.info("executing saveResturantDetails() of ResturantController : " +resturant);
        resturantService.saveResturantDetails(resturant);
    }
    @GetMapping("/find_resturant")
    public @ResponseBody List<Resturant> findResturant(Resturant resturant) {
        return	resturantService.findResturant();
    }
    @GetMapping(value =  AppConstants.FIND_RESTURANTS_BY_ID)
    public Resturant findResturantById(@RequestHeader(name =AppConstants.ID) Long id) {
        return resturantService.findResturantById(id);
    }
    @DeleteMapping("/find_by_id")
    public void deleteResturantById(@RequestHeader(name = AppConstants.ID) Long id) {

        resturantService.deleteResturantById(id);
    }
    @PutMapping("update")
    public void updateResturantDetails(@RequestBody ResturantDto resturantDto) {
        resturantService.updateResturantDetails(resturantDto);
    }
    @GetMapping("/find_by_name")
    public @ResponseBody List<Resturant> findResturantByName(@RequestHeader("resName") String resName) {
        return resturantService.findResturantByName(resName);

    }
}
