package com.bolsadeideas.springboot.backend.apirest.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.singletonMap;
import static org.apache.commons.io.IOUtils.readLines;

public interface TemplateUtil {

    static String process(String template, String variableName, Object variable) {
        return process(template, singletonMap(variableName, variable));
    }

    static String process(String template) {
        return process(template, newHashMap());
    }

    static String process(String template, Map<String, Object> variables) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariables(variables);
        String result = templateEngine.process(template, context);
        return trim(result);
    }

    @SneakyThrows
    static String trim(String result) {
        StringBuilder s = new StringBuilder();
        AtomicBoolean write = new AtomicBoolean(false);
        readLines(new StringReader(result)).stream()
                .filter(StringUtils::isNotBlank)
                .forEach(line -> {
                    if (line.contains("</body>")) {
                        write.set(false);
                    }
                    if (write.get()) {
                        s.append(line.trim()).append("\n");
                    }
                    if (line.contains("<body>")) {
                        write.set(true);
                    }
                });
        return s.toString();
    }

}
