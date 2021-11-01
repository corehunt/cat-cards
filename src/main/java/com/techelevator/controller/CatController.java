package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list() {
        return catCardDao.list();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id){
        return catCardDao.get(id);
    }

//    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
//    public CatCard getRandom(@PathVariable("random") long id){
//        return catCardDao.get(Math.random(id));
//
//    }

    @RequestMapping (path = "/api/cards", method = RequestMethod.POST)
    public boolean save (@RequestBody CatCard cardToSave){
        catCardDao.save(cardToSave);
        return true;
    }

    @RequestMapping (path = "/api/cards/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody CatCard card,  @PathVariable long id ){
        catCardDao.update(id, card);
        return true;
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id){
        catCardDao.delete(id);
        return true;
    }

}
