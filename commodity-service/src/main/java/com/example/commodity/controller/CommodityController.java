package com.example.commodity.controller;

import com.example.commodity.model.Category;
import com.example.commodity.model.Commodity;
import com.example.commodity.model.Language;
import com.example.commodity.service.CommodityService;
import com.example.commodity.tools.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class CommodityController {

    private static final String UPLOADED_FOLDER = "http://localhost:11000/advertIMG/advert/";

    @Autowired
    private CommodityService commodityService;

    @PostMapping("/commodity")
    public String createCommodity(@RequestParam("image") MultipartFile image, Commodity commodity) {

        System.out.println("商品服务——进入createCommodity，参数打印");
        System.out.println(commodity.getName() + "--" + commodity.getAuthor()
                + "--" + commodity.getPrice() + "--" + commodity.getCategory()
                + "--" + commodity.getPublisher() + "--" + commodity.getISBN()
                + "--" + commodity.getLanguage());

        String filename = FileUpload.writeUploadFile(image, "advert");
        if ("NOT_IMAGE".equals(filename))
            return filename;
        String imagePath = UPLOADED_FOLDER + filename;
        commodity.setVisible(1);
        commodity.setImagePath(imagePath);
        commodityService.createCommodity(commodity, 1L); //暂时写死，需要解决共享sesion问题
        return "success";

    }

    @GetMapping("/commodity/{commodityId}")
    public Commodity researchCommodity(@PathVariable(name = "commodityId") Long id) {
        System.out.println("商品服务——进入researchCommodity，参数打印");
        System.out.println(id);
        return commodityService.getCommodity(id);
    }

    @GetMapping("/commodity")
    public List<Commodity> getAllCommodity() {
        System.out.println("商品服务——进入getAllCommodity，参数打印");
        return commodityService.getAllCommodity();
    }

    @GetMapping("/{accountId}/commodity")
    public List<Commodity> getMyCommodity(@PathVariable(name = "accountId") Long id) {
        System.out.println("商品服务——进入getMyCommodity，参数打印");
        System.out.println(id);
        List<Long> commodityId = commodityService.getMyCommodityId(id);
        return commodityService.getMyCommodity(commodityId);
    }

    @PutMapping("/commodity")
    public String updateCommodity(Commodity commodity) {
        System.out.println("商品服务——进入updateCommodity，参数打印");
        System.out.println(commodity.getName() + "--" + commodity.getAuthor()
                + "--" + commodity.getPrice() + "--" + commodity.getCategory()
                + "--" + commodity.getPublisher() + "--" + commodity.getISBN()
                + "--" + commodity.getLanguage() + "--" + commodity.getId());
        // 一定不能出现空值
        commodityService.updateCommodity(commodity);
        return "success";
    }

    @PutMapping("commodity/{commodityId}")
    public String deleteCommodity(@PathVariable(name = "commodityId") Long id) {
        System.out.println("商品服务——进入deleteCommodity，参数打印");
        System.out.println(id);
        Commodity commodity = commodityService.getCommodity(id);
        commodity.setVisible(0);
        commodityService.updateCommodity(commodity);
        return "success";
    }

    @GetMapping("commodity/category")
    public List<Category> getCategory() {
        System.out.println("商品服务——进入getCategory，参数打印");
        Category[] categories = Category.values();
        return Arrays.asList(categories);
    }

    @GetMapping("commodity/language")
    public List<Language> getLanguage() {
        System.out.println("商品服务——进入getLanguage，参数打印");
        Language[] languages = Language.values();
        return Arrays.asList(languages);
    }
}