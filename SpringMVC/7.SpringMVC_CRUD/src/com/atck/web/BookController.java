package com.atck.web;

import com.atck.pojo.Book;
import com.atck.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController
{
    @Autowired
    private CRUDService crudService;

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(Book book)
    {
        System.out.println("addBook");
        // crudService.addBook(book);
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") Integer id)
    {
        System.out.println("deleteBook");
        System.out.println(id);
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String updateBook(@ModelAttribute("book") Book book)
    {
        // crudService.updateBook(book);
        System.out.println("updateBook");
        System.out.println(book);

        return "redirect:/index.jsp";
    }



    @RequestMapping("/books")
    public String books(Model model)
    {
        List<Book> books = crudService.queryBooks();
        model.addAttribute("books",books);
        return "list";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage()
    {
        return "add";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String queryBook(@PathVariable("id") Integer id, Model model)
    {
        Book book = crudService.queryBookById(id);
        model.addAttribute("book",book);

        return "update";
    }

    // @ModelAttribute
    // public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,Model model)
    // {
    //    if (id != null)
    //    {
    //        Book book = crudService.queryBookById(id);
    //        model.addAttribute("book",book);
    //    }
    // }
}
