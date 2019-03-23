package com.example.commodity.controller;

import com.example.commodity.model.Category;
import com.example.commodity.model.Commodity;
import com.example.commodity.model.Language;
import com.example.commodity.service.CommodityService;
import com.example.commodity.tools.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class CommodityController {

    private static final String UPLOADED_FOLDER = "http://localhost:11000/advertIMG/advert/";

    @Autowired
    private CommodityService commodityService;

    @PostMapping("/{accountId}/commodity")
    public String createCommodity(@RequestParam("image") MultipartFile image, Commodity commodity
            , @PathVariable(name = "accountId") Long accountId) {

        System.out.println("商品服务——进入createCommodity，参数打印");
        System.out.println(commodity.getName() + "--" + commodity.getAuthor()
                + "--" + commodity.getPrice() + "--" + commodity.getCategory()
                + "--" + commodity.getPublisher() + "--" + commodity.getISBN()
                + "--" + commodity.getLanguage() + "--" + accountId);

        String filename = FileUpload.writeUploadFile(image, "advert");
        if ("NOT_IMAGE".equals(filename))
            return filename;
        String imagePath = UPLOADED_FOLDER + filename;
        commodity.setVisible(1);
        commodity.setImagePath(imagePath);
        commodityService.createCommodity(commodity, accountId);
        return "success";

    }

    @GetMapping("/commodity/{commodityId}")
    public Commodity researchCommodity(@PathVariable(name = "commodityId") Long id,
                                       HttpSession httpSession, HttpServletRequest request) {
        System.out.println("商品服务——进入researchCommodity，参数打印");
        System.out.println(id);

        System.out.println("session="+httpSession.getId());
        System.out.println("request-session="+request.getSession().getId());

        return commodityService.getCommodity(id);
    }

    @GetMapping("/commodity")
    public List<Commodity> getAllCommodity(HttpSession httpSession, HttpServletRequest request) {
        System.out.println("商品服务——进入getAllCommodity，参数打印");

        System.out.println("session="+httpSession.getId());
        System.out.println("request-session="+request.getSession().getId());

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

    @GetMapping("commodity/{commodityId}/price")
    public BigDecimal getCommodityPrice(@PathVariable(name = "commodityId") Long id) {
        System.out.println("商品服务——进入getCommodityPrice，参数打印");
        System.out.println(id);
        return commodityService.getPriceById(id);
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
