---
name: Clash Native
colors:
  surface: '#0b1326'
  surface-dim: '#0b1326'
  surface-bright: '#31394e'
  surface-container-lowest: '#060d20'
  surface-container-low: '#131b2e'
  surface-container: '#171f33'
  surface-container-high: '#222a3e'
  surface-container-highest: '#2d3449'
  on-surface: '#dbe2fd'
  on-surface-variant: '#bbc9cd'
  inverse-surface: '#dbe2fd'
  inverse-on-surface: '#283044'
  outline: '#859397'
  outline-variant: '#3c494c'
  surface-tint: '#2fd9f4'
  primary: '#8aebff'
  on-primary: '#00363e'
  primary-container: '#22d3ee'
  on-primary-container: '#005763'
  inverse-primary: '#006877'
  secondary: '#c6c6c7'
  on-secondary: '#2f3131'
  secondary-container: '#454747'
  on-secondary-container: '#b4b5b5'
  tertiary: '#ffd6a3'
  on-tertiary: '#462b00'
  tertiary-container: '#ffb13b'
  on-tertiary-container: '#6e4600'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#a2eeff'
  primary-fixed-dim: '#2fd9f4'
  on-primary-fixed: '#001f25'
  on-primary-fixed-variant: '#004e5a'
  secondary-fixed: '#e2e2e2'
  secondary-fixed-dim: '#c6c6c7'
  on-secondary-fixed: '#1a1c1c'
  on-secondary-fixed-variant: '#454747'
  tertiary-fixed: '#ffddb5'
  tertiary-fixed-dim: '#ffb957'
  on-tertiary-fixed: '#2a1800'
  on-tertiary-fixed-variant: '#643f00'
  background: '#0b1326'
  on-background: '#dbe2fd'
  surface-variant: '#2d3449'
typography:
  display-lg:
    fontFamily: Poppins
    fontSize: 48px
    fontWeight: '700'
    lineHeight: 56px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Poppins
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
  headline-lg-mobile:
    fontFamily: Poppins
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  title-md:
    fontFamily: Poppins
    fontSize: 18px
    fontWeight: '600'
    lineHeight: 24px
  body-md:
    fontFamily: Poppins
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-sm:
    fontFamily: Poppins
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.05em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  base: 8px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 32px
  gutter: 16px
  margin-mobile: 16px
  margin-tablet: 24px
---

## Brand & Style

The design system is engineered for a competitive 2-player head-to-head experience on Android. It prioritizes high-speed legibility and clarity of play over decorative flourishes. The aesthetic is **Corporate Modern** with a lean toward a "Dark Mode Tech" vibe, utilizing high-contrast accents to highlight interactive elements against a deep, focused background.

The style follows a strict utilitarian logic: information is layered logically using surface colors, and the primary accent color is reserved exclusively for critical actions and active game states. It avoids visual noise, ensuring that player focus remains entirely on the cards and the competition.

## Colors

This design system utilizes a high-contrast dark palette to reduce eye strain during extended play sessions. 

- **Background**: The foundation is a deep navy-black, providing maximum contrast for foreground elements.
- **Primary (Accent)**: A vibrant Cyan used for primary buttons, selection states, and winning indicators.
- **Surface**: While the user requested White for cards, for a native Android dark-theme experience, we use White specifically for the *card face* and a deep slate (#1E293B) for *UI containers* to maintain visual hierarchy without overwhelming the user's vision.
- **Text**: Pure white is used for maximum readability on dark backgrounds, with scaled opacity (70%) for secondary information.

## Typography

The typography system uses **Poppins** across all levels to maintain a clean, geometric, and modern feel. 

- **Display & Headlines**: Bold weights are used for scores and game announcements. 
- **Body**: Regular weight is used for card descriptions and rules.
- **Labels**: Medium weight with slight tracking (letter-spacing) is used for button text and small UI metadata to ensure legibility at small scales on mobile devices.

## Layout & Spacing

The design system adheres to an **8dp grid**—the standard for Android-native development. 

- **Grid System**: A 4-column fluid grid for mobile and an 8-column grid for tablet/landscape play.
- **Rhythm**: Vertical rhythm is maintained through 8px increments. 16px is the standard margin for mobile screen edges.
- **Game Board**: Cards should have a minimum gutter of 8px between them to ensure touch targets remain distinct.

## Elevation & Depth

In alignment with modern Material principles but stripped of complexity, this design system uses **Tonal Layering** instead of heavy shadows.

- **Level 0 (Background)**: #0B1326.
- **Level 1 (UI Containers/Lists)**: #1E293B (Surface).
- **Level 2 (Active Cards)**: #FFFFFF (Physical card objects).
- **Overlays**: Use a 20% white inner stroke (ghost border) on interactive elements rather than drop shadows to define edges.
- **Interaction**: When a card is "lifted" or selected, apply a 2px stroke of the Primary Accent (#22D3EE) instead of a shadow.

## Shapes

The shape language is friendly yet structured. 

- **Standard Elements**: Small components like chips and input fields use an 8px radius.
- **Cards**: Game cards and modal containers use a 16px (rounded-lg) radius to feel substantial and tactile.
- **Buttons**: Use the 8px radius to maintain a professional, "app-like" feel rather than a toy-like appearance.

## Components

- **Buttons**:
    - **Primary**: Solid #22D3EE fill with #0B1326 text. No shadow.
    - **Secondary**: 1.5px stroke of #FFFFFF with no fill.
- **Game Cards**: 
    - Face: #FFFFFF background, #0B1326 text for contrast. 
    - Back: #1E293B with a #22D3EE geometric pattern or logo.
- **Chips (Status Indicators)**:
    - Small pill shapes with 16px height. Use a semi-transparent white (10% opacity) fill for neutral states.
- **Inputs**:
    - Dark fill (#1E293B) with a bottom-border focus state in Primary Cyan.
- **List Items**:
    - Separated by 1px dividers of white at 10% opacity. 
- **Health/Mana Bars**:
    - Flat, non-gradient progress bars. Background: #1E293B, Fill: #22D3EE.