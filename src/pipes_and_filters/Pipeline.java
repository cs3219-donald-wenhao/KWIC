package pipes_and_filters;

public class Pipeline {
	
	private Filter[] filters;
	
	/**
	 * Constructor - Also creates the pipes in between filters
	 * 
	 * @param filters
	 */
	public Pipeline(Filter ... filters) {
		this.filters = filters;
		
		for (int i = 0; i < filters.length - 1; i++) {
			Pipe pipe = new Pipe();
			filters[i].setOutPipe(pipe);
			filters[i+1].setInPipe(pipe);
		}
	}

	/**
	 * Method to run throug all the filters
	 */
	public void run() {
		for (int i = 0; i < filters.length; i++) {
			filters[i].run();
		}
	}
	
	
}
