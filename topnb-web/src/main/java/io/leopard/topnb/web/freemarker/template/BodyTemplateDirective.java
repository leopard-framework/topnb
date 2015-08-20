package io.leopard.topnb.web.freemarker.template;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 消息Tab.
 * 
 * @author 阿海
 *
 */

public class BodyTemplateDirective implements TemplateDirectiveModel {

	private static ThreadLocal<Map<String, Object>> DATA = new ThreadLocal<Map<String, Object>>();

	public static void setData(Map<String, Object> data) {
		DATA.set(data);
	}

	@Override
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		// String folder = ((SimpleScalar) params.get("template_folder")).getAsString();
		String templateName = ((SimpleScalar) params.get("template_name")).getAsString();
		// String templateName = (String) params.get("template_name");

		Template template = env.getConfiguration().getTemplate(templateName + ".ftl");
		template.process(DATA.get(), env.getOut());
	}

}
