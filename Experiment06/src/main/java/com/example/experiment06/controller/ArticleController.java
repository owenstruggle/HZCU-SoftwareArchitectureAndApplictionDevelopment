package com.example.experiment06.controller;

import com.example.experiment06.entity.Article;
import com.example.experiment06.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Owem
 * @date 2023/4/17 15:59
 * @description TODO
 **/

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    /* Description：文章列表 */
    @RequestMapping("")
    public ModelAndView articleList(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("article/list");
        mav.addObject("page", page);
        return mav;
    }

    /* Description：根据id获取文章对象*/
    @GetMapping("/{id}")
    public ModelAndView article(@PathVariable("id") Integer id) {
        Article articles = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }

    /* Description：新增操作视图 */
    @GetMapping("/add")
    public String addArticle() {
        return "article/add";
    }

    /* Description：新增保存方法*/
    @PostMapping("")
    public String saveArticle(Article model) {
        articleRepository.save(model);
        return "redirect:/article/";
    }

    /* Description：删除 */
    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") long id) {
        articleRepository.deleteById(id);
        return "redirect:";
    }

    /* Description：编辑视图 */
    @GetMapping("/edit/{id}")
    public ModelAndView editArticle(@PathVariable("id") long id) {
        Article model = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article", model);
        return mav;
    }

    /* Description：根据id获取文章对象 */
    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id) {
        Article articles = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }

    /* Description：修改方法 */
    @PutMapping("/{id}")
    public String editArticleSave(Article model, long id) {
        model.setId(id);
        articleRepository.save(model);
        return "redirect:";
    }
}

