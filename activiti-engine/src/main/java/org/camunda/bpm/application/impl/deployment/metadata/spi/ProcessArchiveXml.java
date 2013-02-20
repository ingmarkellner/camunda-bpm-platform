package org.camunda.bpm.application.impl.deployment.metadata.spi;

import java.util.List;
import java.util.Map;

/**
 * <p>Java API representation of a ProcessArchive definition inside a processes.xml file</p>
 * 
 * @author Daniel Meyer
 *
 */
public interface ProcessArchiveXml {

  /** Indicates whether the undeployment of the process archive should trigger deleting the process engine deployment.
   * If the process engine deployment is deleted, all running and historic process instances are removed as well. */
  public static final String PROP_IS_DELETE_UPON_UNDEPLOY = "isDeleteUponUndeploy";  
  
  /** Indicates whether the classloader should be scanned for process definitions. */
  public static final String PROP_IS_SCAN_FOR_PROCESS_DEFINITIONS = "isScanForProcessDefinitions";
  
  /**
   * <p> The resource root of the proccess archive. This property is used when scanning for process definitions 
   * (if {@link #PROP_IS_SCAN_FOR_PROCESS_DEFINITIONS} is set to true).</p>
   * 
   * <p> The path is interpreted as 
   * <ul>
   * 
   *   <li>
   *     <em>local to the root of the classpath.</em>
   *     By default or if the prefix "classpath:" is used, the path is interpreted as relative to the root 
   *     of the classloader. Example: "path/to/my/processes" or "classpath:path/to/my/processes")
   *   </li>
   *   
   *   <li>
   *     <em>relative to the process archive's definig metafile (processes.xml).</em>
   *     If the prefix "pa:" is used, the path is interpreted as relative to the metafile defining the 
   *     process archive. Consider the situation of a process application packaged as a WAR file:
   *     
   *     The deployment structure could look like this:
   *     <pre>
   *     |-- My-Application.war
   *         |-- WEB-INF
   *             |-- lib/
   *                 |-- Sales-Processes.jar 
   *                     |-- META-INF/processes.xml  (1)
   *                     |-- opps/openOpportunity.bpmn    
   *                     |-- leads/openLead.bpmn
   *                      
   *                 |-- Invoice-Processes.jar
   *                     |-- META-INF/processes.xml  (2)  
   *    </pre>     
   *    If the process archive(s) defined in (1) uses a path prefixed with "pa:", like for instance "pa:opps/", 
   *    only the "opps/"-folder of sales-processes.jar is scanned. More presisely, a "pa-local path", is resolved 
   *    relative to the the parent directory of the META-INF-directory containing the defining processes.xml file. 
   *    This implies, that using a pa-local path in (1), no processes from (2) are visible.
   *    <p />    
   *   </li>
   * </ul>
   * </p>
   */
  public static final String PROP_RESOURCE_ROOT_PATH = "resourceRoot";
  
  /**
   * @return the name of the process archive. Must not be null.
   */
  public String getName();
  
  /**
   * @return the name of the process engine which the deployment should be made to. If null, the "default engine" is used. 
   */
  public String getProcessEngineName();

  /**
   * @return a list of process definition resource names that make up the deployment. 
   */
  public List<String> getProcessResourceNames(); 
  
  /**
   * @return a list of additional properties. See constant property names defined in this class for a list of available properties. 
   * 
   * @see #PROP_IS_DELETE_UPON_UNDEPLOY
   * @see #PROP_IS_SCAN_FOR_PROCESS_DEFINITIONS
   * @see #PROP_RESOURCE_ROOT_PATH
   */
  public Map<String, String> getProperties();
  
}