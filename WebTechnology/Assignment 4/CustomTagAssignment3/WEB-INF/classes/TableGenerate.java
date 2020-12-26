package table;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class TableGenerate extends TagSupport{
	int number,limit;
	public void setNumber(int number){
		this.number=number;
	}
	public void setLimit(int limit){
		this.limit=limit;
	}
	@Override
	public int doStartTag()throws JspException{
		JspWriter out = pageContext.getOut();
		try{
			for(int i=0;i<limit;i++){
				out.println("\n"+number + " * "+i+" = "+(number*i));
				System.out.println("\n");
			}
		}
		catch(Exception e){
			System.out.print("Exception occured!"+e.getMessage());
		} 
		return SKIP_BODY;
	}
}