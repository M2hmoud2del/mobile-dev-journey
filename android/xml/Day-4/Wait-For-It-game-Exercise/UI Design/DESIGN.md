---
name: Obsidian Kinetic
colors:
  surface: '#0b1326'
  surface-dim: '#0b1326'
  surface-bright: '#31394d'
  surface-container-lowest: '#060e20'
  surface-container-low: '#131b2e'
  surface-container: '#171f33'
  surface-container-high: '#222a3d'
  surface-container-highest: '#2d3449'
  on-surface: '#dae2fd'
  on-surface-variant: '#bbc9cd'
  inverse-surface: '#dae2fd'
  inverse-on-surface: '#283044'
  outline: '#859397'
  outline-variant: '#3c494c'
  surface-tint: '#2fd9f4'
  primary: '#8aebff'
  on-primary: '#00363e'
  primary-container: '#22d3ee'
  on-primary-container: '#005763'
  inverse-primary: '#006877'
  secondary: '#ddb7ff'
  on-secondary: '#490080'
  secondary-container: '#6f00be'
  on-secondary-container: '#d6a9ff'
  tertiary: '#66f796'
  on-tertiary: '#003919'
  tertiary-container: '#45da7d'
  on-tertiary-container: '#005b2c'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#a2eeff'
  primary-fixed-dim: '#2fd9f4'
  on-primary-fixed: '#001f25'
  on-primary-fixed-variant: '#004e5a'
  secondary-fixed: '#f0dbff'
  secondary-fixed-dim: '#ddb7ff'
  on-secondary-fixed: '#2c0051'
  on-secondary-fixed-variant: '#6900b3'
  tertiary-fixed: '#6dfe9c'
  tertiary-fixed-dim: '#4de082'
  on-tertiary-fixed: '#00210c'
  on-tertiary-fixed-variant: '#005227'
  background: '#0b1326'
  on-background: '#dae2fd'
  surface-variant: '#2d3449'
typography:
  display-lg:
    fontFamily: Inter
    fontSize: 57px
    fontWeight: '800'
    lineHeight: 64px
    letterSpacing: -0.02em
  display-lg-mobile:
    fontFamily: Inter
    fontSize: 45px
    fontWeight: '800'
    lineHeight: 52px
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
  headline-sm:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  title-lg:
    fontFamily: Inter
    fontSize: 22px
    fontWeight: '500'
    lineHeight: 28px
  body-lg:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-md:
    fontFamily: Geist
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.1em
  code-stat:
    fontFamily: Geist
    fontSize: 14px
    fontWeight: '700'
    lineHeight: 20px
rounded:
  sm: 0.5rem
  DEFAULT: 1rem
  md: 1.5rem
  lg: 2rem
  xl: 3rem
  full: 9999px
spacing:
  unit: 8px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 32px
  gutter: 16px
  margin-mobile: 24px
---

## Brand & Style
This design system focuses on high-stakes precision and atmospheric tension for a premium Android gaming experience. The aesthetic merges **Minimalism** with **Futuristic Neon** accents, creating a high-contrast environment where focus is paramount. 

The design narrative is built on the "calm before the storm." Surfaces are deep and expansive, utilizing **Glassmorphism** and subtle background blurs to suggest layers of sophisticated technology. The interface remains unobtrusive until action is required, at which point neon accents provide clear, energetic feedback. It leverages Material Design 3 (M3) structures but replaces standard corporate softness with a sharp, technical edge.

## Colors
The palette is rooted in **Deep Obsidian**, providing a pure black-adjacent canvas that eliminates visual noise. 

- **Primary (Neon Cyan):** Used for critical interactive elements, progress indicators, and active states.
- **Secondary (Electric Violet):** Reserved for rare rewards, special abilities, or secondary branding moments.
- **Tertiary (Signal Green):** Dedicated to "Go" signals and success states.
- **Surface Slate:** Used for inactive "off-lights" and low-priority container strokes to maintain structure without distraction.

All interactive neon colors should utilize a soft outer glow (0-4px blur) of the same hue to simulate light emission.

## Typography
Typography follows a systematic hierarchy designed for legibility during fast-paced gameplay. **Inter** is the primary typeface, chosen for its neutral, technical clarity. For technical data and micro-copy, **Geist** provides a monospaced, developer-centric feel that reinforces the futuristic theme.

Display styles use heavy weights and tight letter-spacing to create a sense of impact. Labels and status indicators use increased tracking and uppercase styling to differentiate them from instructional body text.

## Layout & Spacing
This design system employs a strict **8dp grid** for all spatial relationships. 

- **Touch Targets:** Minimum height for interactive elements is 56dp to ensure accessibility during high-latency gameplay.
- **Safe Zones:** A 24dp margin is maintained from the screen edges to accommodate system gestures and varied device aspect ratios.
- **Containers:** Content is grouped in logical clusters using 16dp spacing (Gutter). 

The layout is fluid, prioritizing central vertical alignment for gameplay elements and anchored positions for UI HUD components.

## Elevation & Depth
Depth is expressed through **Tonal Layering** and **Glassmorphism**, moving away from traditional drop shadows in favor of luminosity.

1.  **Level 0 (Base):** Deep Obsidian (#0F172A).
2.  **Level 1 (Sub-surface):** Slate (#1E293B) with a 1px inner border.
3.  **Level 2 (Active Overlay):** Semi-transparent background (alpha 0.4) with a 20px backdrop-blur and a 1px border colored by the primary neon at 20% opacity.

Instead of black shadows, "Glow Shadows" are used: soft, diffused blurs matching the color of the element (e.g., a Cyan button casts a subtle Cyan glow).

## Shapes
Shapes are unapologetically bold and rounded. Following the **Pill-shaped** philosophy, standard buttons and containers use a 24px+ corner radius to feel tactile and modern. 

- **Primary Buttons:** Fully rounded (pill).
- **Cards/Containers:** 24px or 32px (rounded-xl) to create a friendly contrast against the dark, technical background.
- **Indicators:** Circular for status lights, ensuring they stand out against rectangular UI structures.

## Components

### Buttons
- **Action Button:** Pill-shaped, Primary Neon Cyan background, black text. Subtle outer glow on hover/active.
- **Secondary Button:** 1.5px border in Slate or Cyan, transparent center with backdrop blur.

### Gameplay Lights (The "Ready" Sequence)
- **Inactive State:** 48dp circles with Slate (#334155) fill, no glow.
- **Warning State:** 48dp circles with Secondary Violet fill and a matching 8px glow.
- **Go State:** 48dp circle with Signal Green (#4ADE80) fill and a high-intensity 16px glow.

### HUD Cards
- Use Glassmorphism (20% opacity white/cyan) with a 24px corner radius. 
- Integrated 1px top-edge highlight to simulate light hitting the edge of a glass pane.

### Input Fields
- Underlined style with a focus state that triggers a full-width Neon Cyan glow under the text. 
- Large, bold typography for numerical inputs.

### Lists
- Separated by 8dp gaps rather than dividers.
- Each list item is a discrete glass card with 12px rounded corners.