package servicedesk.web.base.tree;


import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import servicedesk.infrastructure.interfaces.domain.HierarchicalDomainObject;
import servicedesk.web.base.tree.domain.TreeItem;


@Controller
public class TreePickerController {

    @Autowired
    protected BeanFactory beanFactory;
    
    @Autowired
    protected ConversionService conversionService;
    
    @RequestMapping(value = "/servicedesk/treePicker/{builder}", method = RequestMethod.GET)
    public String showView(ModelMap model,
            @PathVariable("builder") String builderName,
            @RequestParam("target") String target,
            @RequestParam("value") String value) {

        TreeBuilder<?,?> builder = getBuilder(builderName);
        List<TreeItem> roots = getRoots(builder.getIdClass(), builder, value);
         
        model.addAttribute("builder", builderName);
        model.addAttribute("target", target);
        model.addAttribute("roots", roots);
        return "servicedesk/treePicker";
    }

    @RequestMapping(value = "/servicedesk/treePicker/{builder}/pick/{id}", method = RequestMethod.GET)
    public String onChoose(ModelMap model, 
        @PathVariable("builder") String builderName,
        @PathVariable("id") String itemId,
        @RequestParam("target") String target) {

        TreeBuilder<?,?> builder = getBuilder(builderName);
        HierarchicalDomainObject<?> item = getItem(
                builder.getIdClass(), 
                builder, 
                StringUtils.hasText(itemId) ? itemId : null );
        
        model.addAttribute("target", target);
        model.addAttribute("item", item);
        return "servicedesk/treePickerChoose";
    }
    
    private <Id extends Serializable> List<TreeItem> getRoots(Class<Id> idClass, TreeBuilder<?,?> builder, String selected) {
        @SuppressWarnings("unchecked")
        TreeBuilder<?, Id> typedBuilder = (TreeBuilder<?, Id>)builder;
        return typedBuilder.buildTree(conversionService.convert(selected, idClass));
    }
    
    private <Id extends Serializable> HierarchicalDomainObject<?> getItem(Class<Id> idClass, TreeBuilder<?,?> builder, String id) {
        @SuppressWarnings("unchecked")
        TreeBuilder<?, Id> typedBuilder = (TreeBuilder<?, Id>)builder;
        return typedBuilder.getItem(conversionService.convert(id, idClass));
    
    }

    private TreeBuilder<?,?> getBuilder(String builderName) {
        return beanFactory.getBean(builderName, TreeBuilder.class);
    }
}
