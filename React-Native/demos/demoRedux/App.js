import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import {Provider} from 'react-redux';
import {store} from './store/redux/store';
import MyId from './MyId';

// npm i @reduxjs/toolkit react-redux

export default function App() {
  return (
    <Provider store={store}>
      <View>
        <Text>App</Text>
        <MyId />
      </View>
    </Provider>
  );
}

const styles = StyleSheet.create({});
