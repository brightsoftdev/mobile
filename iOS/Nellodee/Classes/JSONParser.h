//
//  JSONParser.h
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Profile.h"


@interface JSONParser : NSObject {
    
}

- (Profile*) meService:(NSString*)response;


@end
