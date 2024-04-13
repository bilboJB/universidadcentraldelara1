package bean;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BotonSwitch extends Component implements Serializable {
	private static final long serialVersionUID = 8913369762664440133L;
	private boolean seleccionado;
	private float locacion;
	private Timer timer;
	private float velocidadMovimiento;
	private Color color;
	private boolean mouseOver;
	private List<EventSwitchSelected> events;
	
	public BotonSwitch() {
		color = new Color(0, 174, 255);
		setBackground(color);
        setPreferredSize(new Dimension(50, 25));
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        events = new ArrayList<>();
        velocidadMovimiento = 1.7f;
        locacion = 2;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (isSeleccionado()) {
                    int locacionFinal = getWidth() - getHeight() + 2;
                    if (locacion < locacionFinal) {
                        locacion += velocidadMovimiento;
                        repaint();
                    } else {
                        timer.stop();
                        locacion = locacionFinal;
                        repaint();
                    }
                } else {
                    int locacionFinal = 2;
                    if (locacion > locacionFinal) {
                        locacion -= velocidadMovimiento;
                        repaint();
                    } else {
                        timer.stop();
                        locacion = locacionFinal;
                        repaint();
                    }
                }
            }
        });
        addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent me) {
				if (SwingUtilities.isLeftMouseButton(me)) {
                    if (mouseOver) {
                        seleccionado = !seleccionado;
                        timer.start();
                        runEvent();
                    }
                }
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseOver = false;
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseOver = true;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
        int height = getHeight();
        float alpha = getAlpha();
        if (alpha < 1) {
            g2.setColor(Color.GRAY);
            g2.fillRoundRect(0, 0, width, height, 25, 25);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(getColor());
        g2.fillRoundRect(0, 0, width, height, 25, 25);
        g2.setColor(getForeground());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillOval((int) locacion, 2, height - 4, height - 4);
		super.paint(g);
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
		timer.start();
		runEvent();
	}

	public float getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public void setVelocidadMovimiento(float velocidadMovimiento) {
		this.velocidadMovimiento = velocidadMovimiento;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	private float getAlpha() {
        float width = getWidth() - getHeight();
        float alpha = (locacion - 2) / width;
        if (alpha < 0) {
            alpha = 0;
        }
        if (alpha > 1) {
            alpha = 1;
        }
        return alpha;
    }

	private void runEvent() {
        for (EventSwitchSelected event : events) {
            event.onSelected(seleccionado);
        }
    }
	
	public void addEventSelected(EventSwitchSelected event) {
        events.add(event);
    }
}
