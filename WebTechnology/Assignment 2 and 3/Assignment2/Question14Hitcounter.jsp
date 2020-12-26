<%! 
	void hitCount(String page){
		Integer hit_counter = (Integer)application.getAttribute(page);
			if(hit_counter==null || hit_counter==0){
				out.println("First time visit.Welcome!");
				hit_counter=1;
			}
			else
			{
				hit_counter+=1;
			}
			application.setAttribute(page,hit_counter);
	}
%>