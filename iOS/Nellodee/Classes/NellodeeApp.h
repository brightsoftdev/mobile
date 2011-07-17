//
//  NellodeeApp.h
//  Nellodee
//
//  Created by Ada Hopper on 26/06/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface NellodeeApp : NSObject {
	NSString *sakaiURL;
	NSArray *cookies;

}

//Nellodee config properties
@property (nonatomic, retain) NSString *sakaiURL;

//Shared info
@property (nonatomic, retain) NSArray *cookies;

+ (id)sharedNellodeeData;


@end
