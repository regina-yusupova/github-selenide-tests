package com.yusupova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsPageTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "2100x1080";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    public void shouldHaveCodeExampleForJunit5() {
        // открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $(".m-0.p-0.list-style-none").$(".wiki-more-pages-link").$("button").click();
        $(".wiki-more-pages-link").preceding(0).$("a").shouldHave(exactText("SoftAssertions")).click();

        // открыть страницу SoftAssertions
        $(".wiki-more-pages-link").preceding(0).$("a").click();

        // проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").$$("h4").findBy(text("JUnit5")).shouldHave(text("JUnit5"));
    }
}
