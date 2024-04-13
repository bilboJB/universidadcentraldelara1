package bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class BotonSwitchBeanInfo extends SimpleBeanInfo{
	private Class<BotonSwitch> beanClass = BotonSwitch.class;
	private String iconColor16x16Filename;
	private String iconColor32x32Filename= "BotonSwitch.png";
	private String iconMono16x16Filename;  
	private String iconMono32x32Filename;
	
	public BotonSwitchBeanInfo() {
		super();
	}
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor _velocidadMovimiento = new PropertyDescriptor("velocidadMovimiento", beanClass, "getVelocidadMovimiento","setVelocidadMovimiento");
			PropertyDescriptor _color = new PropertyDescriptor("color", beanClass, "getColor", "setColor");
			PropertyDescriptor[] pds = new PropertyDescriptor[] {
				_velocidadMovimiento,
				_color
			};
			return pds;
		} 
		catch (IntrospectionException ex) {
			ex.printStackTrace();
		    return null;
		}
	}
	
	public java.awt.Image getIcon(int iconKind) {
	    switch (iconKind) {
	    case BeanInfo.ICON_COLOR_16x16:
	      return iconColor16x16Filename != null ? loadImage(iconColor16x16Filename) : null;
	    case BeanInfo.ICON_COLOR_32x32:
	      return iconColor32x32Filename != null ? loadImage(iconColor32x32Filename) : null;
	    case BeanInfo.ICON_MONO_16x16:
	      return iconMono16x16Filename != null ? loadImage(iconMono16x16Filename) : null;
	    case BeanInfo.ICON_MONO_32x32:
	      return iconMono32x32Filename != null ? loadImage(iconMono32x32Filename) : null;
	    }
	    return null;
	  }
}
