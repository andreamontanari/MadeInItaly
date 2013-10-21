package webstore.bb;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;


@Named("delProduct")
@ConversationScoped
public class DelProductBB extends ConversationalBase{

    @Override
    protected String execute() {
        getProductCatalogue().remove(getId());
        return "products";
    }
}
