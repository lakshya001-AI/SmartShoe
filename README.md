# SmartShoe Obstacle Detection System
![image](https://github.com/lakshya001-AI/SmartShoe/assets/114764192/f1dfcbd1-d4e7-4d65-a52b-f997eb8dfceb)
## Table of Contents
- [Introduction](#introduction)
- [Hardware Components](#hardware-components)
- [Software Components](#software-components)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The SmartShoe project is a prototype obstacle detection system that uses an ultrasonic sensor (HC-SR04), an Arduino board, an HC-05 Bluetooth module, and an Android app to detect obstacles in the path of the user and provide real-time feedback. This system is designed to assist visually impaired individuals by alerting them to obstacles in their vicinity.

This README file provides information on the hardware and software components, setup instructions, and usage guidelines for the SmartShoe project.

## Hardware Components

The SmartShoe project requires the following hardware components:

1. **Arduino Board**: This project uses an Arduino board (e.g., Arduino Uno) as the main controller.

2. **Ultrasonic Sensor (HC-SR04)**: The HC-SR04 ultrasonic sensor is used to measure distances and detect obstacles in front of the user.

3. **HC-05 Bluetooth Module**: The HC-05 Bluetooth module is used for wireless communication between the Arduino board and the Android app.

4. **SmartShoe**: The ultrasonic sensor is integrated into a shoe to provide real-time obstacle detection.

5. **Power Source**: Depending on the power requirements of your components, you may need a suitable power source (e.g., battery).

## Software Components

The software components of the SmartShoe project include:

1. **Arduino Sketch**: The Arduino sketch is responsible for reading data from the ultrasonic sensor, processing it, and sending it to the Bluetooth module for transmission to the Android app.

2. **Android App**: The Android app is designed to receive obstacle detection data from the Bluetooth module and display it in a user-friendly interface. You can find the Android app source code in the `android-app` directory.

## Setup Instructions

Follow these steps to set up the SmartShoe project:

1. **Assemble the Hardware**:
   - Connect the HC-SR04 ultrasonic sensor to the Arduino board.
   - Connect the HC-05 Bluetooth module to the Arduino board.
   - Integrate the hardware components into the shoe as per your design.

2. **Install Arduino IDE**:
   - Install the Arduino Integrated Development Environment (IDE) on your computer if you haven't already.

3. **Upload Arduino Sketch**:
   - Open the Arduino sketch provided in the `arduino-code` directory.
   - Select the appropriate Arduino board and COM port in the Arduino IDE.
   - Upload the sketch to the Arduino board.

4. **Install Android App**:
   - Install the SmartShoe Android app on your Android device. You can find the app APK in the `android-app` directory.

5. **Pair HC-05 Module**:
   - Pair the HC-05 Bluetooth module with your Android device.

6. **Configure App**:
   - Open the SmartShoe app on your Android device.
   - Connect the app to the paired HC-05 module.
   - Start using the SmartShoe for obstacle detection.

## Usage

- Wear the SmartShoe and walk around.
- The ultrasonic sensor will detect obstacles in your path.
- The Android app will display real-time feedback on obstacle distance and location.
- The app may provide audio or vibration alerts to notify you of obstacles.

## Contributing

Contributions to the SmartShoe project are welcome. If you'd like to contribute, please follow these guidelines:
- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes and test thoroughly.
- Create a pull request with a clear description of your changes.

## License

The SmartShoe project is open-source software released under the [MIT License](LICENSE). See the [LICENSE](LICENSE) file for details.

---

For any questions or issues, please contact the project maintainers.

Lakshya Makode : makodelakshya101@gmail.com



